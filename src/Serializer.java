import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Serializer {
    private static String filename = "cache/cache.txt";

    public static void writeToFile(AutoAssociator a) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(a);

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.append(json).append("\n");
            writer.flush();
            writer.close();
            System.out.println("Wrote");
        } catch (IOException e) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!! Error writing to file !!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    public static AutoAssociator readFromFile() {
        Gson gson = new Gson();
        var str = Helpers.tail(new File(filename), 1);
        return gson.fromJson(str, AutoAssociator.class);
    }
}
