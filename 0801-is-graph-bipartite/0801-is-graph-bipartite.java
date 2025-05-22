class Solution {
    public boolean bfs(Queue<Integer> queue,int graph[][],int adjColor[]){
        while(!queue.isEmpty()){
            int crnt = queue.poll();
            //traverse over its neigh and paint it in different color meaning 
            for(int neigh:graph[crnt]){
                if(adjColor[neigh]==-1){
                    //not just one while processing the first parent we are coloring its neigh as 1
                    //but these nodes can also be a parent so their children needs to have 0 color.
                    adjColor[neigh]= 1-adjColor[crnt];
                    queue.offer(neigh);
                }else if(adjColor[neigh]==adjColor[crnt]) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int adjColor[] = new int[graph.length];
        Arrays.fill(adjColor,-1);
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            //start with a new node which is not yet colored "-1"
            if(adjColor[i]==-1){
                    //when you first visit a node and its not colored meaning it is a parent color it as 0 and push it into the queue
                    adjColor[i]=0;
                    queue.offer(i);
                    if(!bfs(queue,graph,adjColor)) return false;
            }
        }
        return true;
    }
}