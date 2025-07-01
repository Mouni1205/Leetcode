class Solution {
    public int possibleStringCount(String word) {
        int count = 1;
        int duplicate = word.charAt(0);
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)==duplicate) count++;
            duplicate = word.charAt(i);
        }
        return count;
    }
}