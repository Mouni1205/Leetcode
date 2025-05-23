class Solution {
    int xdir[]={0,0,-1,+1};
    int ydir[]={-1,+1,0,0};
    public void dfs(int i,int j,boolean visited[][],char grid[][],int n,int m){
        if(i<0||j<0||i>=n || j>=m||visited[i][j]||grid[i][j]=='0') return;
        visited[i][j]=true;
        for(int k=0;k<4;k++){
            dfs(i+xdir[k],j+ydir[k],visited,grid,n,m);
        }
        return;
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][]= new boolean[n][m];
        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]&&grid[i][j]=='1'){
                    dfs(i,j,visited,grid,n,m);
                    result++;
                }
            }
        }
        return result;
    }
}