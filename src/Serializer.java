import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Serializer {
    public static void writeToFile(String filename, AutoAssociator a) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(a);

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.append(json).append("\n");
        writer.flush();
        writer.close();
        System.out.println("Wrote");
    }

    public static AutoAssociator readFromFile(String filename) {
        return null;
    }
}
