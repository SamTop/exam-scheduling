import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tests extends JFrame implements ActionListener {

    private JPanel screen = new JPanel(), tools = new JPanel();
    private JButton[] tool;
    private JTextField[] field;
    private CourseArray courses;
    private Color[] CRScolor = {Color.RED, Color.GREEN, Color.BLACK};

    public Tests() {
        super("Dynamic Time Table");
        setSize(500, 800);
        setLayout(new FlowLayout());

        screen.setPreferredSize(new Dimension(400, 800));
        add(screen);

        setTools();
        add(tools);

        setVisible(false);
    }

    public void setTools() {
        String capField[] = {"Slots:", "Courses:", "Clash File:", "Iters:", "Shift:"};
        field = new JTextField[capField.length];

        String capButton[] = {"Load", "Start", "Cont", "Step", "Print", "Exit"};
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

        field[0].setText("10");
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

    public void actionPerformed(ActionEvent click) {

    }

    public void load(int slots, int courseNum, String file) {
        System.out.println("Loading file: " + file);
        System.out.println("Slot: " + slots);
        courses = new CourseArray(courseNum + 1, slots);
        courses.readClashes("data/" + file);
    }

    public void reset() {
        for (int i = 1; i < courses.length(); i++) courses.setSlot(i, 0);
    }

    public int iterate(int iters, int shift) {
        int clashes, min=Integer.MAX_VALUE, step=-1;
        for (int iteration = 1; iteration <= iters; iteration++) {
            courses.iterate(shift);
            clashes = courses.clashesLeft();
            if (clashes < min) {
                min = clashes;
                step = iteration;
            }
        }
        System.out.println("Shift = " + shift + " Iterations = " + iters + "\tMin clashes = " + min + "\tat step " + step);
        return min;
    }

    public void test() {
        String[] files = {"ute-s-92.stu"};
        int[] courseNums = {184};
        int[] slotNumbers = {12, 11, 10, 9, 8};
        int[] iterations = {8, 128, 1024, 8196};

        for (int i = 0; i < files.length; ++i) {
            for (var slotNum : slotNumbers) {
                load(slotNum, courseNums[i], files[i]);

                for (int shift = 1; shift <= slotNum; ++shift) {
                    System.out.println();
                    for (int iter : iterations) {
                        reset();
                        int min = iterate(iter, shift);
                        if (min == 0) {
                            break;
                        }
                    }
                }

            }
        }

    }

    public static void main(String[] args) {
        var a = new Tests();
        a.test();
    }
}
