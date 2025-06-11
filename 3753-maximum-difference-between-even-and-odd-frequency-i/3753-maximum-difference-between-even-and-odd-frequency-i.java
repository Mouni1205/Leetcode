class Solution {
    public int maxDifference(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int oddMax = Integer.MIN_VALUE;
        int evenMin = Integer.MAX_VALUE;
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int x:map.values()){
            if(x%2!=0 && x>oddMax) oddMax = x;
            else if(x%2==0 && x<evenMin) evenMin = x;
        }
        return oddMax-evenMin;
    }
}