class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int result[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<n;i++){
            while(!stack.empty()&&temperatures[stack.peek()]<temperatures[i]){
                int crnt = stack.pop();
                result[crnt] = i-crnt;
            }
            stack.push(i);
        }
        return result;
    }
}