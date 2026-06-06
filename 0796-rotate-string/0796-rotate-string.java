class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        //When you double the string, you're creating a "window" where every possible split point becomes visible as a contiguous substring.
        s+=s;
        return s.contains(goal);
    }
}