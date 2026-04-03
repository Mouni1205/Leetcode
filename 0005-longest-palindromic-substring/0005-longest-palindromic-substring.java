class Solution {
    private Boolean[][] memo;

    public String longestPalindrome(String s) {
        int n = s.length();
        memo = new Boolean[n][n]; 
        String longest = "";

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j) && (j - i + 1 > longest.length())) {
                    longest = s.substring(i, j + 1);
                }
            }
        }
        return longest;
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (i >= j) return true; // Base case: single char or empty
        if (memo[i][j] != null) return memo[i][j]; 
        memo[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome(s, i + 1, j - 1);
        return memo[i][j];
    }
}