import java.util.*;

public class WeddingComplex {
    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        Map<String, String> matches = new HashMap<>();
        Map<String, String> rev = new HashMap<>();
        Queue<String> free = new LinkedList<>(first.keySet());
        Map<String, Integer> proposals = new HashMap<>();
        
        for (String m : first.keySet()) proposals.put(m, 0);
        
        while (!free.isEmpty()) {
            String m = free.poll();
            int idx = proposals.get(m);
            if (idx >= first.get(m).size()) continue;
            
            String w = first.get(m).get(idx);
            proposals.put(m, idx + 1);
            
            if (!rev.containsKey(w)) {
                matches.put(m, w);
                rev.put(w, m);
            } else {
                String curr = rev.get(w);
                List<String> prefs = second.get(w);
                if (prefs.indexOf(m) < prefs.indexOf(curr)) {
                    matches.remove(curr);
                    matches.put(m, w);
                    rev.put(w, m);
                    free.add(curr);
                } else {
                    free.add(m);
                }
            }
        }
        
        return matches;
    }
}