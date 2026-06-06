class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> set = new HashSet<>();
        int result = 0;
        for(char ch:word.toCharArray()){
            if(!set.contains(ch)){
            if(ch>='a'&&ch<='z'){
                if(set.contains(Character.toUpperCase(ch))) result++;
            }
            else if(ch>='A'&&ch<='Z'){
                if(set.contains(Character.toLowerCase(ch))) result++;
            }
            }
            set.add(ch);
        }
        return result;
    }
}