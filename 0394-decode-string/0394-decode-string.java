class Solution {
    public String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<StringBuilder> stackSB = new Stack<>();
        StringBuilder str = new StringBuilder();
        int number = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '[') {
                stack.push(number);
                stackSB.push(str);
                str = new StringBuilder();
                number = 0;
            } else if (c == ']') {
                int repeat = stack.pop();
                StringBuilder current = stackSB.pop();
                for (int i = 0; i < repeat; i++) current.append(str);
                str = current;
            } else {
                str.append(c);
            }
        }

        return str.toString();
    }
}