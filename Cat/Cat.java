import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        for (String fileName : args) {
            try (BufferedInputStream br = new BufferedInputStream(new FileInputStream(fileName))) {
                int line;
                while ((line = br.read()) != -1) {
                    System.out.print((char) line);
                }

            }catch (IOException e) {

            }
        }
    }
}