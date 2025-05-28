class Solution {
    int xdir[]={0,0,-1,1};
    int ydir[]={1,-1,0,0};
    public boolean dfs(boolean visited[][],int i,int j,int k,char[][] board,String word){

        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j] || word.charAt(k)!=board[i][j])
            return false;

        visited[i][j]=true;
        if(k==word.length()-1) return true;
        
        for(int dir=0;dir<4;dir++){
            if(dfs(visited,i+xdir[dir],j+ydir[dir],k+1,board,word)) return true;
        }
        visited[i][j]=false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && word.charAt(0)==board[i][j]){
                    if(dfs(visited,i,j,0,board,word)) return true;
                }
            }
        }
        return false;
    }
}