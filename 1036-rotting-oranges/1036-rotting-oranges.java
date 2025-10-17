import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0;
        int minutes = 0;

        while (!q.isEmpty()&&fresh>0) {
            int size = q.size();
            minutes++; 

            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];

                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;   
                        fresh--;           
                        q.offer(new int[]{nr, nc}); 
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}
