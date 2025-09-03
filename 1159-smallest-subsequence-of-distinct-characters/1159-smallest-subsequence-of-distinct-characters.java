class Solution {
    public String smallestSubsequence(String s) {
         int freq[]=new int[26];
        for(char x:s.toCharArray()) freq[x-'a']++;
        boolean isPresent[]= new boolean[26];
         Stack<Character> stack = new Stack<>();
         for(char x:s.toCharArray()){
            freq[x-'a']--;
            if(isPresent[x-'a'])continue;
            while(!stack.isEmpty()&&stack.peek()>x){
                if(freq[stack.peek()-'a']==0) break;
                isPresent[stack.pop()-'a']=false;
            }
            stack.push(x);
            isPresent[x-'a']=true;
         }
          StringBuilder result = new StringBuilder();
    while (!stack.empty()) {
        result.append(stack.pop());
    }
    return result.reverse().toString();
    }
}