class Solution {
    // public int helper(String s1,String s2,int i,int j,Integer dp[][]){
    //     if(i<0 ) return j+1;
    //     if(j<0) return i+1;
    //     if(dp[i][j]!=null) return dp[i][j];
    //     if(s1.charAt(i)==s2.charAt(j)) dp[i][j] = helper(s1,s2,i-1,j-1,dp);
    //     else dp[i][j] = Math.min(1+helper(s1,s2,i-1,j,dp),1+helper(s1,s2,i,j-1,dp));
    //     return dp[i][j];
    // }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        //Integer dp[][] = new Integer[n+1][m+1];
        int prev[] = new int[m+1];
        int crnt[] = new int[m+1];
        //for(int i=0;i<=n;i++) dp[i][0] = i;
        for(int j=0;j<=m;j++) prev[j] = j;
        for(int i=1;i<=n;i++){
            crnt[0] = i;
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) crnt[j] = prev[j-1];
                else crnt[j] = Math.min(1+prev[j],1+crnt[j-1]);
            }
            int temp[]=prev;
            prev = crnt;
            crnt = temp;
        }
        return prev[m];
    }
}