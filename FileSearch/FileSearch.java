import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class FileSearch {
    public static String searchFile(String fileName) {
        Path startDir = Paths.get("documents");

        try {
            Optional<Path> found = Files.walk(startDir)
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().equals(fileName))
                    .findFirst();

            if (found.isPresent()) {
                return startDir.relativize(found.get()).toString();
            } else {
                return null;
            }
        } catch (IOException e) {
            return null;
        }
    }
}