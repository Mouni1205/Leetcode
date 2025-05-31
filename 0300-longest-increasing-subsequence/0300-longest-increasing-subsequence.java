class Solution {
    public int helper(int nums[],int i,int prev,Integer dp[][]){
        if(i==nums.length) return 0;
        if (dp[i][prev + 1] != null) return dp[i][prev + 1];
        //not take
        int len = helper(nums,i+1,prev,dp);
        //take
        if(prev==-1||nums[i]>nums[prev]) len = Math.max(len,1+helper(nums,i+1,i,dp));
        return dp[i][prev+1] = len;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer dp[][]=new Integer[n][n+1];
        return helper(nums,0,-1,dp);
    }
}