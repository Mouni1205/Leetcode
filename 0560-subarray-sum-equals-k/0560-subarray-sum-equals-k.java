/*
Distance traveled = prefixSum
Target distance = k
If  b−k (current total distance minus target) matches a previous distance, it means we’ve found our starting point for traveling exactly 
k
k.
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefixSum = 0;
        map.put(0,1);
        int count = 0;
        for(int num:nums){
            prefixSum+=num;
            count+=map.getOrDefault(prefixSum-k,0);
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}