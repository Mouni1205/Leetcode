//first thought should be are they sorted 
//we need to sort and intervals are overlapped when the new interval's high is in between or more than the 
//previous high 

class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int low = intervals[0][0];
        int high = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=low && intervals[i][0]<=high){
                high = Math.max(high,intervals[i][1]);
            } else {
                result.add(new int[]{low,high});
                low = intervals[i][0];
                high = intervals[i][1];
            }
        }

        result.add(new int[]{low,high});

        int arr[][]=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            for(int j=0;j<2;j++){
                int crnt[] = result.get(i);
                arr[i][j] = crnt[j];
            }
        }
        return arr;
    }
}
