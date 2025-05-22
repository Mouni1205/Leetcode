class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //create a adj list
        List<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int time[]:times){
            adj.get(time[0]).add(new int[]{time[1],time[2]});
        }
        //Make PQ sort the elements based on the time
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a,b) -> a[1]-b[1]
        );
        //dist array to keep track of the minimum 
        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        //this is important because input is 1 based and to reach 0 it's going to be 0
        dist[0] = 0;
        //we start from k which is our source and the time to reach this is 0
        dist[k] = 0;
        queue.offer(new int[]{k,0});
        
        while(!queue.isEmpty()){
            int crnt[] = queue.poll();
             int node = crnt[0];
             int time = crnt[1];
            //if the already calculated time to reach this current node is more than the signal to reach from the current node which is 
            //neigh node time + curr node time, from the current node we have to find a neigh which will take less time 
            for(int neigh[]:adj.get(crnt[0])){
                if(dist[neigh[0]]>time+neigh[1]){
                    //update the dist array and add this newly calculated less time to the queue 
                    dist[neigh[0]] = time+neigh[1];
                    queue.offer(new int[]{neigh[0],time+neigh[1]});
                }
            }
        }

        //if a certain node is not reachable return -1 and we need minimum time to reach all nodes so we have to take the maximum time from the dist
        int result = 0;
        for(int dis:dist){
            if(dis==Integer.MAX_VALUE) return -1;
            result = Math.max(result,dis);
        }
        return result;
    }
}