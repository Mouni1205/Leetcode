//Sliding Window + Hashmap
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int start = 0;
        int result =0;
        for(int end = 0;end<fruits.length;end++){
            map.put(fruits[end],map.getOrDefault(fruits[end],0)+1);
            //Remove either of the previous kind of fruit that's in the basket
            if(map.size()>2){
                while(map.size()>2){
                    map.put(fruits[start],map.getOrDefault(fruits[start],0)-1);
                    if(map.get(fruits[start])==0) map.remove(fruits[start]);
                    start++;
                }
            }
            result = Math.max(result,end-start+1);
        }
        return result; 
    }
}