class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // Traverse first and last column for Pacific and Atlantic respectively
        for (int row = 0; row < n; row++) {
            dfs(row, 0, pacific, heights);
            dfs(row, m - 1, atlantic, heights);
        }

        // Traverse first and last row for Pacific and Atlantic respectively
        for (int col = 0; col < m; col++) {
            dfs(0, col, pacific, heights);
            dfs(n - 1, col, atlantic, heights);
        }

        // Find all cells that can flow to both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int row, int col, boolean[][] ocean, int[][] heights) {
        ocean[row][col] = true;
        for (int[] dir : directions) {
            int r = row + dir[0], c = col + dir[1];
            if (r >= 0 && c >= 0 && r < heights.length && c < heights[0].length) {
                if (!ocean[r][c] && heights[r][c] >= heights[row][col]) { // Flow from high to low or equal height
                    dfs(r, c, ocean, heights);
                }
            }
        }
    }
}