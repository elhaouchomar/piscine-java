import java.util.ArrayList;
import java.util.List;

public class CleanExtract {
    public static String extract(String s) {
        String[] text = s.split("\\|");
        List<String> reList = new ArrayList<>();

        for (String word : text) {
            word = word.trim();
            int firstDot = word.indexOf(".");
            int lastDot = word.lastIndexOf(".");

            if (firstDot != -1 && lastDot != -1 && firstDot < lastDot) {
                String extracted = word.substring(firstDot + 1, lastDot).trim();
                if (!extracted.isEmpty()) {
                    reList.add(extracted);
                }
            } else if (firstDot != -1) {
                String extracted = word.substring(firstDot + 1).trim();
                if (!extracted.isEmpty()) {
                    reList.add(extracted);
                }
            } else if (!word.isEmpty()) {
                reList.add(word.trim());
            }
        }

        return String.join(" ", reList).trim();
    }
}
