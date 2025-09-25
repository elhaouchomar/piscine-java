import java.io.*;
import java.util.Scanner;

public class CatInFile {
    public static void cat(String[] args) throws IOException {

        String outputFile = args[0];
        try (
                BufferedInputStream in = new BufferedInputStream(System.in);
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outputFile))) {
            byte[] buffer = new byte[1024];
            int bytread;
            while ((bytread = in.read(buffer)) != -1)
                out.write(buffer, 0, bytread);

        } catch (Exception e) {
        }
    }
}