class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> queue = new PriorityQueue<>((x,y)->y[0]-x[0]);
        if(a>0) queue.offer(new int[]{a,'a'});
        if(b>0) queue.offer(new int[]{b,'b'});
        if(c>0) queue.offer(new int[]{c,'c'});

        //idea is to keep appending freq char and if it's same as last two then we will append second freq
        while(!queue.isEmpty()){
           int[] first = queue.poll();
            if (sb.length() > 1 && sb.charAt(sb.length() - 1) == first[1] && sb.charAt(sb.length() - 2) == first[1]) {
                if (queue.isEmpty()) break;
                int[] second = queue.poll();
                sb.append((char) second[1]);
                second[0]--;
                if (second[0] > 0) queue.offer(second);
                queue.offer(first);
            } else {
                sb.append((char) first[1]);
                first[0]--;
                if (first[0] > 0) queue.offer(first);
            }
        }

        return sb.toString();
    }
}