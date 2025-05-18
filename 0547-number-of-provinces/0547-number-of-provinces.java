class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;

        for (int j = 0; j < n; j++) {
            if (!visited[j]) {
                queue.offer(j);  // Start BFS from the current unvisited city
                visited[j] = true;  // Mark as visited
                result++;  // Increment province count

                while (!queue.isEmpty()) {
                    int crnt = queue.poll();
                    for (int i = 0; i < n; i++) {
                        if (isConnected[crnt][i] == 1 && !visited[i]) {
                            queue.offer(i);
                            visited[i] = true;
                        }
                    }
                }
            }
        }
        return result;
    }
}