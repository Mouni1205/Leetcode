class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int leftSum[]=new int[n];
        int rightSum[]=new int[n];
        for(int i=1;i<n;i++) leftSum[i]=leftSum[i-1]+nums[i-1];
        for(int i=n-2;i>=0;i--) rightSum[i]=rightSum[i+1]+nums[i+1];
        int k = 0;
        while(k<n){
            if(leftSum[k]==rightSum[k]) return k;
            k++;
        }
        return -1;
    }
}