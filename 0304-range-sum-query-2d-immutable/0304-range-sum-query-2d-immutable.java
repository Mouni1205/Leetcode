class NumMatrix {
    int prefix[][];
    public NumMatrix(int[][] matrix) {
        int m = matrix[0].length;//col
        int n = matrix.length;//row
        prefix = new int[n+1][m+1];//to handle out of bounds
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                //sum of the rectangle above + sum of the left rectangle - element that was repeated twice + current element
                prefix[i][j] = prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1]+matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        //we prefix starts from 1 so increment all these by 1 
        row1++;col1++;row2++;col2++;
        //remove the upper rectangle and the left rectangle and add the number that's removed twice
        return prefix[row2][col2]-prefix[row1-1][col2]-prefix[row2][col1-1]+prefix[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */