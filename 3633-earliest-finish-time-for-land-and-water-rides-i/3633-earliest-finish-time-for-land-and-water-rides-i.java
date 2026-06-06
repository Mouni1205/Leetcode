class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
    int n = landStartTime.length;
    int m = waterStartTime.length;
    int min = Integer.MAX_VALUE;
    for(int i=0;i<n;i++){
        int landFinish = landStartTime[i]+landDuration[i];
        for(int j=0;j<m;j++){
            int waterFinish = waterStartTime[j]+waterDuration[j];
            //land first
            int landFirst = Math.max(landFinish, waterStartTime[j]) + waterDuration[j];
            //water first
            int waterFirst = Math.max(waterFinish, landStartTime[i]) + landDuration[i];
            min = Math.min(min, Math.min(landFirst, waterFirst));
        }
    }
    return min;
}
}