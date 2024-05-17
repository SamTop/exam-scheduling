import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

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

    public static AutoAssociator readFromFile(int l) {
        Gson gson = new Gson();
        String str;
        var f = new File(filename);
        int lineCount = 0;
        try (Stream<String> stream = Files.lines(Paths.get(filename), StandardCharsets.UTF_8)) {
            lineCount = (int) stream.count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (l == -1) {
            str = Helpers.tail(f, 1);
        } else {
            str = Helpers.tail(f, lineCount - l + 1);
        }

        return gson.fromJson(str, AutoAssociator.class);
    }
}
