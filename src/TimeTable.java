import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.Serial;
import javax.swing.*;
import java.util.Random;

public class TimeTable extends JFrame implements ActionListener {

    private JPanel screen = new JPanel(), tools = new JPanel();
    private JButton tool[];
    private JTextField field[];
    private CourseArray courses;
    private Color CRScolor[] = {Color.RED, Color.GREEN, Color.BLACK};
    private AutoAssociator associator;
    private int[][] minStateSlotStats;
    private int[][] minState;
    private final Random random = new Random();

    public TimeTable() throws IOException {
        super("Dynamic Time Table");

        setSize(500, 800);
        setLayout(new FlowLayout());

        screen.setPreferredSize(new Dimension(400, 800));
        add(screen);

        setTools();
        add(tools);

        setVisible(true);
    }

    public void setTools() {
        String capField[] = {"Slots:", "Courses:", "Clash File:", "Iters:", "Shift:", "Trainslot:"};
        field = new JTextField[capField.length];

        String capButton[] = {"Load", "Start", "Cont", "Step", "Train", "Update", "Print", "Exit"};
        tool = new JButton[capButton.length];

        tools.setLayout(new GridLayout(2 * capField.length + capButton.length, 1));

        for (int i = 0; i < field.length; i++) {
            tools.add(new JLabel(capField[i]));
            field[i] = new JTextField(5);
            tools.add(field[i]);
        }

        for (int i = 0; i < tool.length; i++) {
            tool[i] = new JButton(capButton[i]);
            tool[i].addActionListener(this);
            tools.add(tool[i]);
        }

        field[0].setText("8");
        field[1].setText("184");
        field[2].setText("ute-s-92.stu");
        field[3].setText("1");
    }

    public void draw() {
        Graphics g = screen.getGraphics();
        int width = Integer.parseInt(field[0].getText()) * 10;
        for (int courseIndex = 1; courseIndex < courses.length(); courseIndex++) {
            g.setColor(CRScolor[courses.status(courseIndex) > 0 ? 0 : 1]);
            g.drawLine(0, courseIndex, width, courseIndex);
            g.setColor(CRScolor[CRScolor.length - 1]);
            g.drawLine(10 * courses.slot(courseIndex), courseIndex, 10 * courses.slot(courseIndex) + 10, courseIndex);
        }
    }

    private int getButtonIndex(JButton source) {
        int result = 0;
        while (source != tool[result]) result++;
        return result;
    }

    public void actionPerformed(ActionEvent click) {
        int min, step, clashes;

        switch (getButtonIndex((JButton) click.getSource())) {
            case 0:
                int slots = Integer.parseInt(field[0].getText());
                courses = new CourseArray(Integer.parseInt(field[1].getText()) + 1, slots);
                courses.readClashes("data/" + field[2].getText());
                associator = new AutoAssociator(courses);
                minState = new int[courses.getPeriod()][courses.length()];
                minStateSlotStats = new int[courses.getPeriod()][2];

                draw();
                break;
            case 1:
                min = Integer.MAX_VALUE;
                step = 0;
                for (int i = 1; i < courses.length(); i++) courses.setSlot(i, 0);

                for (int iteration = 1; iteration <= Integer.parseInt(field[3].getText()); iteration++) {
                    courses.iterate(Integer.parseInt(field[4].getText()));
                    draw();
                    clashes = courses.clashesLeft();
                    if (clashes < min) {
                        min = clashes;
                        step = iteration;
                        whenMinFound();
                    }
                }
                System.out.println("Iters = " + field[3].getText() + " Shift = " + field[4].getText() + "\tMin clashes = " + min + "\tat step " + step);
                whenIterationsEnded();
                setVisible(true);
                break;
            case 2:
                min = Integer.MAX_VALUE;
                step = 0;

                for (int iteration = 1; iteration <= Integer.parseInt(field[3].getText()); iteration++) {
                    courses.iterate(Integer.parseInt(field[4].getText()));
                    draw();
                    clashes = courses.clashesLeft();
                    if (clashes < min) {
                        min = clashes;
                        step = iteration;
                        whenMinFound();
                    }
                }
                System.out.println("Iters = " + field[3].getText() + " Shift = " + field[4].getText() + "\tMin clashes = " + min + "\tat step " + step);
                whenIterationsEnded();
                setVisible(true);
                break;
            case 3:
                courses.iterate(Integer.parseInt(field[4].getText()));
                draw();
                break;
            case 4:
                train();
                break;
            case 5:
                for (int i = 0; i < courses.getPeriod(); i++) {
                    if (courses.slotStatus(i)[1] == 0) {
                        continue;
                    }
                    update(i);
                }
                clashes = courses.clashesLeft();
                System.out.println("Clashes " + clashes);
                draw();
                break;
            case 6:
                System.out.println("Exam\tSlot\tClashes");
                for (int i = 1; i < courses.length(); i++)
                    System.out.println(i + "\t" + courses.slot(i) + "\t" + courses.status(i));
                break;
            case 7:
                System.exit(0);
        }
    }

    public void calcSlotStats() {
        for (int i = 0; i < courses.getPeriod(); ++i) {
            minStateSlotStats[i] = courses.slotStatus(i);
        }
    }

    public void printSlotStats() {
        for (int i = 0; i < minStateSlotStats.length; i++) {
            System.out.println("Slot: " + i + "\t" + minStateSlotStats[i][0] + "\t" + minStateSlotStats[i][1]);
        }
    }

    public void memorizeMinState() {
        for (int s = 0; s < courses.getPeriod(); s++) {
            for (int i = 1; i < courses.length(); i++) {
                minState[s][i] = -1;
            }
        }

        for (int i = 1; i < courses.length(); i++) {
            minState[courses.slot(i)][i] = 1;
        }
    }

    public void whenMinFound() {
        memorizeMinState();
        calcSlotStats();
    }

    public void whenIterationsEnded() {
        printSlotStats();
    }

    public void train() {
        associator.training(minState[Integer.parseInt(field[5].getText())]);
        System.out.println("Completed " + associator.getTrainCounter() + " trainings");
    }

    public void update(int slot) {
        int[] timeSlots = courses.getTimeSlot(slot);
        int index = associator.unitUpdate(timeSlots);
        int[] tempSlots = courses.getTimeSlot(slot);
        if (timeSlots[index] != tempSlots[index]) {
            if (timeSlots[index] == 1) {
                courses.setSlot(index, slot);
            } else {
                courses.setSlot(index, random.nextInt(courses.getPeriod() + 1) - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new TimeTable();
    }
}
