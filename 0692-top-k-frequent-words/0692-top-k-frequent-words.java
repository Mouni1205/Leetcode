import java.util.*;

import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Count frequencies
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Create buckets based on frequency
        List<String>[] buckets = new List[words.length + 1];
        for (String word : freqMap.keySet()) {
            int freq = freqMap.get(word);
            if (buckets[freq] == null) buckets[freq] = new ArrayList<>();
            buckets[freq].add(word);
        }

        // Result list
        List<String> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                Collections.sort(buckets[i]); // Sort lexicographically
                result.addAll(buckets[i]);
            }
        }

        return result.subList(0, k); // Return top K
    }
}