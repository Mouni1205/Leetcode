class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);
        int result = 0;

        //new sequence starts when num-1 is not present in the set
        for(int num:set){
            if(!set.contains(num-1)){
                int curr = 1;
                while(set.contains(++num)) curr++;
                result = Math.max(curr,result);
            }
        }
        return result;
    }
}