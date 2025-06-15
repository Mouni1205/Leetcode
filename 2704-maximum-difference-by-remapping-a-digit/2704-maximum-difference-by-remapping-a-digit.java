class Solution {
    public int minMaxDifference(int num) {
        String number = String.valueOf(num);

        // For max value
        char candidate = ' ';
        StringBuilder maxNum = new StringBuilder(number);
        for (int i = 0; i < maxNum.length(); i++) {
            char crnt = maxNum.charAt(i);
            if (candidate != ' ' && crnt == candidate) {
                maxNum.setCharAt(i, '9');
            } else if (crnt != '9' && candidate == ' ') {
                candidate = crnt;
                maxNum.setCharAt(i, '9');
            }
        }

        // For min value
        candidate = ' ';
        StringBuilder minNum = new StringBuilder(number);
        for (int i = 0; i < minNum.length(); i++) {
            char crnt = minNum.charAt(i);
            if (candidate != ' ' && crnt == candidate) {
                minNum.setCharAt(i, '0');
            } else if (crnt != '0' && candidate == ' ') {
                candidate = crnt;
                minNum.setCharAt(i, '0');
            }
        }

        int max = Integer.parseInt(maxNum.toString());
        int min = Integer.parseInt(minNum.toString());

        return max - min;
    }
}
