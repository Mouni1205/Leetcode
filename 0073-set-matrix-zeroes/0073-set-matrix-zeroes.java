class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<int[]> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0;i<n;i++){
            for(int j= 0;j<m;j++){
                if(matrix[i][j]==0) list.add(new int[]{i,j});
            }
        }
        for(int[] zero:list){
            setZero(matrix,zero[0],zero[1],n,m);
        }
    }
    public void setZero(int matrix[][],int i,int j,int n,int m){
        //for column
        for(int col=0;col<n;col++) matrix[col][j]=0;
        //for row
        for(int row=0;row<m;row++) matrix[i][row]=0;
    }
}