class Solution {
    public int helper(String s, int i,int j,Integer dp[][]){
    if(i>=j) return 0;
    if(dp[i][j]!=null) return dp[i][j];
    if(s.charAt(i)==s.charAt(j)) dp[i][j] = helper(s,i+1,j-1,dp);
    else dp[i][j]=1+Math.min(
            helper(s,i+1,j,dp),
            helper(s,i,j-1,dp)
        ); 
        return dp[i][j];
    }
    public int minInsertions(String s) {
        int n = s.length();
        Integer dp[][] = new Integer[n][n];
        return helper(s,0,n-1,dp);
    }
}