class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] result = new int[n];

        // first sort based on the time 
        PriorityQueue<int[]> taskQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]); 
        for (int i = 0; i < n; i++) {
            taskQueue.offer(new int[]{tasks[i][0], tasks[i][1], i});
        }

        //to sort them based on processing time and then index
        PriorityQueue<int[]> availableQueue = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[2] - b[2]; 
            return a[1] - b[1];
        });

        int time = taskQueue.peek()[0], index = 0;

        while (!taskQueue.isEmpty() || !availableQueue.isEmpty()) {
            // Step 3: Move all available tasks to the availableQueue
            while (!taskQueue.isEmpty() && taskQueue.peek()[0] <= time) {
                availableQueue.offer(taskQueue.poll());
            }

            // Step 4: If no tasks are available, jump time forward
            if (availableQueue.isEmpty()) {
                time = taskQueue.peek()[0];
                continue;
            }

            // Step 5: Process task
            int[] task = availableQueue.poll();
            time += task[1]; // Increase time by processingTime
            result[index++] = task[2]; // Store original index
        }

        return result;
    }
}
