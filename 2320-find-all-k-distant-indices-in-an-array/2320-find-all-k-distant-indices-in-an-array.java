class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int nextKeyRangeStart = -1; 
        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                int start = Math.max(0, j - k);
                int end = Math.min(n - 1, j + k);
            
                start = Math.max(start, nextKeyRangeStart);

                for (int i = start; i <= end; i++) {
                    result.add(i);
                }

                nextKeyRangeStart = end + 1;
            }
        }

        return result;
    }
}