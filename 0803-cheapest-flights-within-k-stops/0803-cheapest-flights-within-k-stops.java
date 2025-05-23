class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int maxStops) {
        // Adjacency list: from -> List of {to, price}
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<int[]>());

        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], price = flight[2];
            adj.get(from).add(new int[]{to, price});
        }

        // Distance array: min cost to reach each node
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        // Priority Queue: [stops, currentNode, currentCost]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int stops = curr[0];
            int currentNode = curr[1];
            int currentCost = curr[2];

            if (stops > maxStops) continue;

            for (int[] neighbor : adj.get(currentNode)) {
                int nextNode = neighbor[0];
                int priceToNext = neighbor[1];
                int newCost = currentCost + priceToNext;

                if (newCost < minCost[nextNode]) {
                    minCost[nextNode] = newCost;
                    pq.offer(new int[]{stops + 1, nextNode, newCost});
                }
            }
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
