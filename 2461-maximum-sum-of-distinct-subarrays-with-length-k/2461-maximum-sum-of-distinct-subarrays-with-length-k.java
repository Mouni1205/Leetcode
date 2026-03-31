class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();
        int start = 0;
        long currentSum = 0;
        long maxSum = 0;

        for (int end = 0; end < nums.length; end++) {
            // Remove duplicates from the set
            while (numSet.contains(nums[end])) {
                currentSum -= nums[start];
                numSet.remove(nums[start]);
                start++;
            }

            // Add the current element to the set and update the sum
            numSet.add(nums[end]);
            currentSum += nums[end];

            // Check if the window size is k and all elements are unique
            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);

                // Contract the window for the next iteration
                currentSum -= nums[start];
                numSet.remove(nums[start]);
                start++;
            }
        }

        return maxSum;
    }
}