class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int weight:weights){
            low = Math.max(low,weight);
            high+=weight;
        }
        //binary search on the answer
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canShip(mid,weights,days)) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
    public boolean canShip(int capacity,int weights[],int days){
        int dayCount = 1;
        int currLoad = 0;
        for(int weight:weights){
            if(currLoad+weight>capacity){
                dayCount++;
                currLoad = 0;
            }
            currLoad+=weight;
            if(dayCount>days) return false;
        }
        return true;
    }
}