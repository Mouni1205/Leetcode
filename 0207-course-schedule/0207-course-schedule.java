//classic topo sort question we can take any course whose indegree is 0 and if the count of such courses is equal to the numCourses that 
//means we can finish all courses with the given conditions
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int inDegree[] = new int[numCourses];
        List<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int pre[]:prerequisites){
            //should complete b before a
            adj.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        //indegree 0 means we have a course which is not a prereq to anything else
        for(int i=0;i<inDegree.length;i++){
           if(inDegree[i]==0) queue.offer(i);
        }
        int result = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            result++;
            for(int neigh:adj.get(node)){
                if(--inDegree[neigh]==0) queue.offer(neigh);
            }
        }
        return result==numCourses;
    }
}