public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String st = new StringBuilder(s).reverse().toString();
        return s.equals(st);
    }
}