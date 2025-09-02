class Solution {
    public int numSquares(int n) {
        //queue to explore all possible sums of perfect squares 
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.offer(n);
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                int crnt = queue.poll();
                for(int j=1;j*j<=crnt;j++){
                    int next = crnt - (j*j);
                    if(next == 0) return level;
                    if(!set.contains(next)){
                        set.add(next);
                        queue.offer(next);
                    }
                }
            }
        }
        return level;
    }
}