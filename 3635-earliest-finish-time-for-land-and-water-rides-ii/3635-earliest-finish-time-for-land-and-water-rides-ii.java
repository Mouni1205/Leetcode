class Solution {
public int getFinishTime(int[] start1,
        int[] duration1,
        int[] start2,
        int[] duration2
    ) {
        int finish1 = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++) {
            finish1 = Math.min(finish1, start1[i] + duration1[i]);
        }
        int finish2 = Integer.MAX_VALUE;
        for (int i = 0; i < start2.length; i++) {
            finish2 = Math.min(
                finish2,
                Math.max(start2[i], finish1) + duration2[i]
            );
        }
        return finish2;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
    
    //According to the qstn we can either do land+water or water land
    //so we need min(land+water, water+land)
    //for these two activities we need to find the min land activity first and then 
    //min of landactivity+wateractivity 

    int landWater = getFinishTime(landStartTime,
            landDuration,
            waterStartTime,
            waterDuration);
    int waterLand = getFinishTime(waterStartTime,
            waterDuration,
            landStartTime,
            landDuration);
            return Math.min(landWater,waterLand);

}
}