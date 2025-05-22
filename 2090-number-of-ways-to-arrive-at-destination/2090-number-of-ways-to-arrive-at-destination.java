class Solution {
    public int countPaths(int n, int[][] roads) {
        // Initialize graph
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        // Initialize adjacent nodes bidirectional
        for (int road[] : roads) {
            adj.get(road[0]).add(new int[]{road[2], road[1]});
            adj.get(road[1]).add(new int[]{road[2], road[0]});
        }

        // Shortest time to reach each node
        long[] minTime = new long[n];
        // Number of ways to reach node
        int[] ways = new int[n];
        Arrays.fill(minTime, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        // Order them based on time
        PriorityQueue<long[]> queue = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        queue.offer(new long[]{0, 0}); // {time, node}
        ways[0] = 1; // 1 way to start from node

        int mod = (int) (1e9 + 7);

        while (!queue.isEmpty()) {
            long[] crnt = queue.poll();
            long time = crnt[0];
            int node = (int) crnt[1];

            for (int[] neighs : adj.get(node)) {
                long wt = neighs[0];
                int neigh = neighs[1];
                if (time + wt < minTime[neigh]) {
                    // Update shortest time and ways for the neighbor
                    ways[neigh] = ways[node];
                    minTime[neigh] = time + wt;
                    queue.offer(new long[]{minTime[neigh], neigh});
                } else if (time + wt == minTime[neigh]) {
                    // If same time, add the number of ways
                    ways[neigh] = (ways[neigh] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }
}