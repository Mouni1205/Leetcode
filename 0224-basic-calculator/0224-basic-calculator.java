class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        int sign = 1;
        int result = 0;
        for(char ch:s.toCharArray()){

            //if the char is a digit
            if(Character.isDigit(ch)) curr = 10*curr+(int) (ch-'0');

            else if(ch=='+'){
                //we sign*curr even for + bcoz -3+2 is valid  
                result+= sign * curr;
                sign = 1;
                curr=0;
            }else if(ch=='-'){
                result+= sign * curr;
                sign = -1;
                curr = 0;
            } else if(ch=='('){
                stack.push(result);
                stack.push(sign);
                result =0;
                sign=1;

            }else if(ch==')'){
                result += sign*curr;
                curr = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if(curr != 0) result += sign * curr;
    return result;
    }
}