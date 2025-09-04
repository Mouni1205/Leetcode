class Solution {
    public int minOperations(String[] logs) {
        int result = 0;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../")) {
                result--;
                if (result < 0) result = 0;
            } else if (Character.isLetterOrDigit(logs[i].charAt(0))) {
                result++;
            }  
        }
        return result;   
    }
}