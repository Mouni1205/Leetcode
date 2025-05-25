class Solution {
    public boolean bfs(int m,int graph[][],int clr[],int n){
        clr[m] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(m);
        while(!queue.isEmpty()){
            int crnt = queue.poll();
            for(int i:graph[crnt]){
                if(clr[i]==-1){
                    queue.offer(i);
                    clr[i]=1-clr[crnt];//clr it with the opposite color
                }else if(clr[i]==clr[crnt]) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int clr[] = new int[n];
        Arrays.fill(clr,-1);
        for(int i=0;i<n;i++){
            if(clr[i]==-1){
                if(!bfs(i,graph,clr,n)) return false;
            }
        }
        return true;
    }
}