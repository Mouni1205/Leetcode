class Solution {
    public int minReorder(int n, int[][] connections) {
        // Adjacency list with direction flag: 1 = needs reverse, 0 = okay
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] conn : connections) {
            int from = conn[0], to = conn[1];
            adj.get(from).add(new int[]{to, 1}); // original edge
            adj.get(to).add(new int[]{from, 0}); // reverse edge, doesn't need change
        }

        boolean[] visited = new boolean[n];
        return dfs(0, adj, visited);
    }

    private int dfs(int node, List<List<int[]>> adj, boolean[] visited) {
        visited[node] = true;
        int changes = 0;

        for (int[] neighbor : adj.get(node)) {
            int nextNode = neighbor[0];
            int direction = neighbor[1];

            if (!visited[nextNode]) {
                changes += direction; // if edge was originally from node → nextNode, we count it
                changes += dfs(nextNode, adj, visited);
            }
        }

        return changes;
    }
}
