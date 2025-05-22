class Solution {
   /* public int dfs(ArrayList<ArrayList<int[]>> adj,int src,int dst,int k,int result,int min){
        
        if(src==dst) min = Math.min(result,min);
        if(k<0) return min;
        for(int node[]:adj.get(src)){
            result+=node[1];
            if(result<min)
            min = dfs(adj,node[0],dst,k-1,result,min);
            result-=node[1];
        }
        return min; 
    }*/
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //initializing graph 
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<int[]>());
        }
        for(int flight[]:flights){
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }

        //start with BFS dijkstra's

        //we need this so that we can start with minimum stops each time but this is our first priority
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            //order them based on steps 
            (a,b) -> a[0]-b[0]
        );
        //we need this so that we can take care of the minimum distance travelled although this is not our first priority but we need
        //path with minimum cost when the steps are same or like the minumum steps.
        //Tracks the minimum cost to reach each node.
        int minCost[] = new int[n];
        Arrays.fill(minCost,Integer.MAX_VALUE);

        queue.offer(new int[]{0,src,0});
        
        while(!queue.isEmpty()){
            int crnt[] = queue.poll();

            // to reach node we took these many steps in this cost
            int steps = crnt[0];
            int node = crnt[1];
            int cost = crnt[2];

            //If the number of stops exceeds the allowed limit (k), skip this path since it’s invalid.
            if(steps>k) continue;

            //Iterate over neighbor
            for(int neighs[]:adj.get(node)){
                int neigh = neighs[0];
                int edgeWt = neighs[1];
                //if new wt which is the cost to reach parent plus to reach its adj node is less that means we found an alternative path 
                //to reach this adjacent node 
                if(cost+edgeWt<minCost[neigh]){
                    minCost[neigh] = cost+edgeWt;
                    queue.offer(new int[]{steps+1,neigh,minCost[neigh]});
                }
            }
        }
        return minCost[dst]==Integer.MAX_VALUE?-1:minCost[dst];
    }
}