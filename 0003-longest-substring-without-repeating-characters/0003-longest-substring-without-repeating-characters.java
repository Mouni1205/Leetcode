class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Forgetting the max operation can cause the left pointer to move backwards if the duplicate character's last occurrence is before the current window start
        HashMap<Character,Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;
        for(int r=0;r<s.length();r++){
            char curr = s.charAt(r);
            if(map.containsKey(curr)) l = Math.max(l,map.get(curr)+1);
            map.put(curr,r);
            res= Math.max(res,r-l+1);
        }
        return res;
    }
}