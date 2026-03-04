class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int max = 0 ;
        for(int x:nums){
            if(x==0) count = 0;
            else{
                count++;
                if(count>max) max = count;
            }
        }
        return max;
    }
}