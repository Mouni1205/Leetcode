class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String operation:operations){
            if(operation.equals("+")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int sum = num1+num2;
                stack.push(num1);
                stack.push(num2);
                stack.push(sum);
            }
            else if(operation.equals("D")){
                int prev = stack.pop();
                stack.push(prev);
                stack.push(prev*2);
            }
            else if(operation.equals("C")) stack.pop();
            else stack.push(Integer.valueOf(operation));
        }
        int result=0;
        while(!stack.isEmpty()) result+=stack.pop();
        return result;
    }
}