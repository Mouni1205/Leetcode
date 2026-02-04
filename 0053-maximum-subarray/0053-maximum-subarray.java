class Solution {
    public int maxSubArray(int[] nums) {
        int current_sofar = nums[0];
        int max_sofar = nums[0];

        for(int j = 1; j < nums.length; j++)
        {
            current_sofar = Math.max(nums[j], nums[j] + current_sofar);
            max_sofar = Math.max(current_sofar, max_sofar);
        }

        return max_sofar;
    }
}