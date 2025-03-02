package hashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;

        System.out.println(topKFrequent(words, k));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0) return new ArrayList<>();

        Map<String, Integer> dict = new HashMap<>();
        for (String word : words) {
            dict.put(word, dict.getOrDefault(word, 0) + 1);
        }

        return dict.entrySet().stream().sorted((a, b) -> {
            int compare = b.getValue().compareTo(a.getValue());
            if (compare == 0) {
                return a.getKey().compareTo(b.getKey());
            }
            return compare;
        }).map(Map.Entry::getKey).limit(k).toList();
    }
}
