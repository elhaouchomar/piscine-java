import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
        if (list == null) {
            return List.of();
        }
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        return sorted;

    }

    public static List<Integer> sortReverse(List<Integer> list) {
        if (list == null) {
            return List.of();
        }
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted, Collections.reverseOrder());
        return sorted;
    }
}