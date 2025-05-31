class Solution {
    // public int helper(String text1,String text2,int n,int m,Integer dp[][]){
    //     if(n<0 || m<0) return 0;
    //     if(dp[n][m]!=null) return dp[n][m];
    //     if(text1.charAt(n)==text2.charAt(m)) dp[n][m] = 1+helper(text1,text2,n-1,m-1,dp);
    //     else dp[n][m] = Math.max(helper(text1,text2,n-1,m,dp),helper(text1,text2,n,m-1,dp));
    //     return dp[n][m];
    // }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        //we are shifting that means we are considering the given string in 1 index based.! since we can't
        //have negative index and our recursive base case is when <0 so we make 0 represent a valid base in 
        //tabulation.
        Integer dp[][] = new Integer[n+1][m+1];
        for(int i=0;i<=m;i++) dp[0][i] = 0;
        for(int j=0;j<=n;j++) dp[j][0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}