class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int indegree[] = new int[numCourses];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++) list.add(new ArrayList<>());
        for(int prereq[]:prerequisites){
            indegree[prereq[0]]++;
            list.get(prereq[1]).add(prereq[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) queue.add(i);
        }
        int result[] = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            result[index++] = node;
            for(int i:list.get(node)){
                if(--indegree[i]==0) queue.offer(i);
            }
        }
        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }
}