class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int leftSum[]=new int[n];
        leftSum[0]=nums[0];
        int k= 1;
        for(int i=k;i<n;i++) leftSum[k++] = nums[i]+leftSum[i-1];
        int right = nums[n-1];
        k=n-2;
        for(;k>0;k--){
            if(leftSum[k-1]==right) return k;
            right+=nums[k];
        }
        if(k==0 && right==0) return 0; 
        return -1;
    }
}