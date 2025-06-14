
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            Queue<int[]> queue = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            queue.offer(new int[]{u, -1});
            visited[u] = true;

            boolean foundCycle = false;

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int node = curr[0], parent = curr[1];

                if (node == v) {
                    foundCycle = true;
                    break;
                }

                for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(new int[]{neighbor, node});
                    } 
                }
            }

            if (foundCycle) {
                return edge;
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[0]; 
    }
}
