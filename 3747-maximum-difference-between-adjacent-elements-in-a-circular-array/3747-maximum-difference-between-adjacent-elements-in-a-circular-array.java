class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int result = Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
            result = Math.max(result,Math.abs(nums[i]-nums[i+1]));
        }
        result = Math.max(result,Math.abs(nums[nums.length-1]-nums[0]));
        return result;
    }
}