class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for(String str:logs){
            if(str.equals("../")){
                if(!stack.empty()) stack.pop();
                continue;
            } 
            else if(str.equals("./")) continue;
            else stack.push(str);
        }
        return stack.size();
    }
}