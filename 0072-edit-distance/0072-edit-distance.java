class Solution {
    public int helper(String word1,String word2,int i,int j,Integer dp[][]){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=null) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)) dp[i][j] = helper(word1,word2,i-1,j-1,dp);
        else{
            dp[i][j] = 1+Math.min(
                //insertion
                helper(word1,word2,i,j-1,dp),
                //deletion
                Math.min(helper(word1,word2,i-1,j,dp),
                //replace
                helper(word1,word2,i-1,j-1,dp))
            );
        }
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int prev[] = new int[m+1];
        int crnt[] = new int[m+1];
       // Integer dp[][]=new Integer[n+1][m+1];
       // for(int i=0;i<=n;i++) dp[i][0] = i;
        for(int j=0;j<=m;j++) prev[j] = j;
        for(int i=1;i<=n;i++){
            crnt[0] = i; 
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) crnt[j] = prev[j-1];
        else{
            crnt[j] = 1+Math.min(
                //insertion
                prev[j],
                //deletion
               Math.min( crnt[j-1],
                //replace
                prev[j-1])
            );
        }
            }
            int temp[] = prev;
            prev = crnt;
            crnt = temp;
        }
        return prev[m];
    }
}