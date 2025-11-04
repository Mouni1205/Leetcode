class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        //we have to leverage the constraint that the numbers range from 1-50
        int n = nums.length;
        //problem is finding sum of top x numbers along with their freq of every subarray of size k 
        int result[] = new int[n-k+1];
        for(int i=0;i<result.length;i++){
            result[i]=getXSum(nums,i,i+k-1,x);
        }
        return result;
    }
    public int getXSum(int nums[],int start,int end,int x){
        //since we know the range is till 50 we will store the freq and for each subarray we will traverse to get the required xsum freq elements
        
        //first lets calc freq and then if number of distinct numbers are <x we just return the sum of the subarray

        int max = 50;
        int freq[]=new int[max+1];
        int unique = 0;
        int subSum = 0;

        for(int i=start;i<=end;i++){
            int num = nums[i];
            subSum+=num;
            if(freq[num]==0) unique++;
            freq[num]++;
        }
        
        if(unique<x) return subSum;

        int result = 0;
        for(int i=0;i<x;i++){
            int num = -1;
            int bestFreq = -1;
            for(int j=max;j>=1;j--){
                if(freq[j]>bestFreq){
                    bestFreq = freq[j];
                    num = j;
                }
            }
            if(num!=-1){
                result += num*bestFreq;
                freq[num]=0;
            }
        }
        return result;

    }
}