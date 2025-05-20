//DFS - Traverse from the given point and it's adjacent connected node with the given color
class Solution {
    int xdir[] = {+1,-1,0,0};
    int ydir[] = {0,0,1,-1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean visited[][]=new boolean[image.length][image[0].length];
        dfs(image,sr,sc,color,visited,image[sr][sc]);
        return image;
    }
    public void dfs(int image[][],int row,int col,int color,boolean visited[][],int org){
        if(row<0 || col<0 || row>=image.length || col>=image[0].length || visited[row][col] || image[row][col]!=org) return;
        image[row][col] = color;
        visited[row][col] = true;
        for(int i=0;i<4;i++)
            dfs(image,row+xdir[i],col+ydir[i],color,visited,org);
        return;
    }
}
