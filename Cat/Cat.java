import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        for (String fileName : args) {
            try (BufferedInputStream br = new BufferedInputStream(new FileInputStream(fileName))) {
                byte[] bf = new byte[1024];
                int bytread;

                while ((bytread = br.read(bf)) != -1) {
                    for (int i = 0; i < bytread; i++) {
                        System.out.print((char) bf[i]);
                    }
                }

            }catch (IOException e) {

            }
        }
    }
}