class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char crnt = s.charAt(i);
            if(crnt=='(') stack.push(')');
            else if(crnt=='{') stack.push('}');
            else if(crnt=='[') stack.push(']');
            else if(stack.isEmpty() || stack.pop()!=crnt) return false;
        }
        return stack.empty();
    }
}