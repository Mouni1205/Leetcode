class Solution {
    public long minOperations(int[] nums) {
        long res = 0;
        for(int i=0;i<nums.length-1;i++){
            res+=Math.max(0,nums[i]-nums[i+1]);
        }return res;
    }
}