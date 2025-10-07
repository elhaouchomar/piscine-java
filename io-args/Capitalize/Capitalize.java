import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        String inputFile = args[0];
        String outputFile = args[1];

        FileOutputStream out = new FileOutputStream(outputFile);

        String r = new String(Files.readAllBytes(Paths.get(inputFile)));
        String[] resCap = r.split("\\s+");
        StringBuilder res = new StringBuilder();

        for (String word : resCap) {
            if (!word.isEmpty()) {
                res.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    res.append(word.substring(1).toLowerCase());
                }
            }
            res.append(" ");
        }

        out.write(res.toString().trim().getBytes());
        out.close();
    }
}
