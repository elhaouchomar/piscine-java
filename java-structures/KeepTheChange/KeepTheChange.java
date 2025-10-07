import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> coinList = new ArrayList<>(coins);
        coinList.sort(Collections.reverseOrder());

        List<Integer> res = new ArrayList<>();
        int ramaining = amount;

        for (int coin : coinList) {
            while (ramaining >= coin) {
                res.add(coin);
                ramaining -= coin;
            }
        }
        return res;
    }
}