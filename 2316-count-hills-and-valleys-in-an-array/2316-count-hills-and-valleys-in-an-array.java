class Solution {
    public int countHillValley(int[] nums) {
       int result = 0;
        int left = nums[0];
        for(int i=1; i<nums.length-1; i++){
            //we dont care about the duplicates we only update left when we find either a valley or hill
            if((nums[i] < left && nums[i] < nums[i+1]) || (nums[i] > left && nums[i] > nums[i+1])){
                result++;
                left = nums[i];
            }
        }
        return result;
    }
}