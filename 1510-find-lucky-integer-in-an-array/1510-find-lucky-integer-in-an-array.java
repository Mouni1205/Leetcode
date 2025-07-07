class Solution {
    public int findLucky(int[] arr) {
        int result = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x:arr){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(int x:map.keySet()){
            if(x==map.get(x)) result = x;
        }
        return result;
    }
}