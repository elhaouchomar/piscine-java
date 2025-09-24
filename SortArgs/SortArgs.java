import java.util.Arrays;

public class SortArgs {
    public static void sort(String[] args) {
        Arrays.sort(args);
        System.out.println(String.join(" ", args));
    }
}