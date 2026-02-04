class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int freq = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==candidate) freq++;
            else{
            freq--;
            if(freq==0){candidate = nums[i];
            freq=1;
            }
            }
        }
        freq=0;
        for(int num:nums){
            if(num==candidate) freq++;
        }
        if(freq>nums.length/2) return candidate;
        return -1;
    }
}