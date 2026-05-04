class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int result[]=new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            //remove elements less than the current
            while(!deque.isEmpty() && nums[i]>nums[deque.peekLast()])
                deque.removeLast();
            //remove the element that's out of the window
            if(!deque.isEmpty() && deque.peekFirst()==i-k) 
                deque.pop();
            deque.add(i);
            if(i<k-1) continue;
            result[i-k+1]=nums[deque.peekFirst()];
        }
        return result;
    }
}