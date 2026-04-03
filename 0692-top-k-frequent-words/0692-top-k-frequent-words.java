import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Count frequencies
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Create a priority queue
        PriorityQueue<String> pq = new PriorityQueue<>(
            (w1, w2) -> freqMap.get(w1).equals(freqMap.get(w2)) 
                        ? w1.compareTo(w2) 
                        : freqMap.get(w2) - freqMap.get(w1)
        );

        // Add words to the priority queue
        pq.addAll(freqMap.keySet());

        // Extract top K words
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }

        return result;
    }
}