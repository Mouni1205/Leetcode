class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        //src,dst,time -> src- dst,time
        for(int time[]:times) adj.get(time[0]).add(new int[]{time[1],time[2]});

        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a,b) -> a[1]-b[1]
        );

        queue.offer(new int[]{k,0});
        dist[0]=0;
        dist[k]=0;
        while(!queue.isEmpty()){
            int crnt[] = queue.poll();
            int node = crnt[0];
            int time = crnt[1];
            for(int neigh[]:adj.get(node)){
                //if crnt is less than the already calculated value
                if(neigh[1]+time<dist[neigh[0]]){
                    dist[neigh[0]] = neigh[1]+time;
                    queue.offer(new int[]{neigh[0],dist[neigh[0]]});
                }
            }
        }
        int minTime = Integer.MIN_VALUE;
        for(int x:dist){
            if(x==Integer.MAX_VALUE) return -1;
            minTime = Math.max(minTime,x);
        }
        return minTime;
    }
}