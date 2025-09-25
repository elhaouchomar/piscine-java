import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        for (String fileName : args) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.print(line);
                }

            }catch (IOException e) {

            }
        }
    }
}