class Solution {
    public int[] productExceptSelf(int[] nums) {
        int result[]=new int[nums.length];
        result[0] = 1;
        //this will store the left product at each of the index
        for(int i=1;i<nums.length;i++) result[i] = nums[i-1] * result[i-1];

        //this will get the right product
        int rightProd = 1;
        for(int i=nums.length-1;i>=0;i--) {
            result[i] *= rightProd;
            rightProd *= nums[i];
        }

        return result;

    }
}