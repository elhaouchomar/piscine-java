public class StringContains {
    public static boolean isStringContainedIn(String subString, String s) {
        if (subString == null || s == null) {
            return false;
        } else {
            return s.contains(subString);
        }
    }
}