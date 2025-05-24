//thought process: Anagrams are something where two strings will have the same freq of letters based on this if we could have data structure 
//which stores the unique keys which represents the string in a numerical way and keep on adding the strings to that group which have the 
//same numerical representation of the string
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String str:strs){
            int freq[]=new int[26];
            for(char ch:str.toCharArray())
                freq[ch-'a']++;
            String key = Arrays.toString(freq);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(str);   
        }
        return new ArrayList<>(map.values());
    }
}