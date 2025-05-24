class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x:nums)
            map.put(x,map.getOrDefault(x,0)+1);
        List<Integer>[] bucket = new List[nums.length+1]; // Array of list basically 
        //for each value we are accessing the bucket at the index which is equal to value and 
        //the add the keys which have the same value.
        for(int x:map.keySet()){
            int freq = map.get(x);
            if(bucket[freq]==null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(x);
        }
        int result[] = new int[k];
        int counter=0;
        //since we want the top k frequent elements we are iterating from last in bucket array 
        //at which ever index the value is not null we are iterating the arraylist at that index and 
        //adding to the list.
        for(int i = bucket.length-1;i>=0 && counter <k;i--){
            if(bucket[i]!=null){
                for(Integer num:bucket[i]) {
                    result[counter++]=num;
                }
            }
        }
        return result;
    }
}