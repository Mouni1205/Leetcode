class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Frequency Map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        // Step 2: Bucket - index = frequency, value = list of numbers
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++)
            buckets.add(new ArrayList<>());  // initialize empty lists

        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            buckets.get(freq).add(num);
        }

        // Step 3: Collect top k frequent elements from end of buckets
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.size() - 1; i >= 0 && result.size() < k; i--) {
            if (!buckets.get(i).isEmpty()) {
                result.addAll(buckets.get(i));
            }
        }

        // Convert to array
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = result.get(i);
        return res;
    }
}
