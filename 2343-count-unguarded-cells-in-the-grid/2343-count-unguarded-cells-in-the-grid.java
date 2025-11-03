class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int grid[][] = new int[m][n];
        //0 - unguarded, 1 - gurdable, 2 - guard, 3 - wall
        //first lets fill our grid
        for(int guard[]:guards) grid[guard[0]][guard[1]] = 2;
        for(int wall[]:walls) grid[wall[0]][wall[1]] = 3;

        //for each guard we will traverse from all the four directions like literally not just graph like 4 directions
        for(int guard[]:guards){
            mark_guarded(guard[0],guard[1],grid);
        }
        int result = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) result++;
            }
        }
        return result;
    }
    public void mark_guarded(int row,int col,int grid[][]){
        //top
        for(int i=row-1;i>=0;i--){
            if(grid[i][col]==2 || grid[i][col]==3) break;
            grid[i][col] = 1; 
        }
        //left
        for(int j=col-1;j>=0;j--){
            if(grid[row][j]==2 || grid[row][j]==3) break;
            grid[row][j] = 1; 
        }
        //right
        for(int j=col+1;j<grid[0].length;j++){
            if(grid[row][j]==2 || grid[row][j]==3) break;
            grid[row][j] = 1; 
        }
        //down
        for(int i=row+1;i<grid.length;i++){
            if(grid[i][col]==2 || grid[i][col]==3) break;
            grid[i][col] = 1; 
        }
    }
}