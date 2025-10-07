import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParseDate {
    
    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(stringDate, formatter);
    }
    
    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        String[] words = stringDate.split(" ");
        words[0] = capitalize(words[0]);
        words[2] = capitalize(words[2]);
        String formattedDate = String.join(" ", words);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", Locale.ENGLISH);
        return LocalDate.parse(formattedDate, formatter);
    }
    
    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
    
    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        String[] parts = stringDate.split(",");
        
        String hourPart = parts[0].trim();
        String[] hourTokens = hourPart.split(" ");
        int hours = Integer.parseInt(hourTokens[0]);
        
        if (hourPart.contains("evening") || hourPart.contains("afternoon")) {
            if (hours != 12) {
                hours += 12;
            }
        } else if (hourPart.contains("morning") && hours == 12) {
            hours = 0;
        }
        
        String minutePart = parts[1].trim();
        String[] minuteTokens = minutePart.split(" ");
        int minutes = Integer.parseInt(minuteTokens[0]);
        
        String secondPart = parts[1].trim();
        String[] secondTokens = secondPart.split("and");
        String[] secTokens = secondTokens[1].trim().split(" ");
        int seconds = Integer.parseInt(secTokens[0]);
        
        return LocalTime.of(hours, minutes, seconds);
    }
}