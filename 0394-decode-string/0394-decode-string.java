
class Solution {
    public String decodeString(String s) {
        Stack<Pair<StringBuilder, Integer>> stack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // Build the number
            } else if (c == '[') {
                stack.push(new Pair<>(currentStr, num)); // Push current string and number
                currentStr = new StringBuilder(); // Reset for new substring
                num = 0;
            } else if (c == ']') {
                Pair<StringBuilder, Integer> p = stack.pop(); // Pop from stack
                StringBuilder prevStr = p.getKey();
                int repeat = p.getValue();
                for (int i = 0; i < repeat; i++) prevStr.append(currentStr); // Repeat and append
                currentStr = prevStr; // Update current string
            } else {
                currentStr.append(c); // Build current string
            }
        }
        return currentStr.toString();
    }
}