class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> nums[i2]-nums[i1]);
        int n= nums.length;
        int[] output = new int[n-k+1];
        int outputIndex = 0;
        for(int i=0; i<nums.length; i++) {
            while(!pq.isEmpty() && pq.peek()<i-k+1) { 
                pq.remove();
            }
            pq.add(i);
            
            if(i-k+1>=0) {
                output[outputIndex++] = nums[pq.peek()];
            }
        }
        
        return output;
    }
}