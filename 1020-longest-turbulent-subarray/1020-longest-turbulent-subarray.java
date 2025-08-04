class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int left=0,right=1;
        String prev = "";
        int result = 1;
        while(right<arr.length){
            //case 1: if a<b then their previous pair shouldn't be <
            if(arr[right-1]<arr[right] && !prev.equals("<")){
                result = Math.max(result,right-left+1);
                prev = "<";
                right++;
            }//case 2: if a>b then their previous pair shouldn't be >
            else if(arr[right-1]>arr[right]&& !prev.equals(">")){
                result = Math.max(result,right-left+1);
                prev = ">";
                right++;
            }//case 3: a==b or it doesn't follow turbulence pattern 
            else{
                //if both the elements are same we want the window to start from right+1 since the turbulance can't
                //start from this pair but if it's not following the sequence we might need start again from the current pair 
                //since we might get a new longer subarray from this pair 
                right = (arr[right]==arr[right-1]) ? right+1 : right;
                left = right-1;
                prev = "";
            }
        }
        return result;
    }
}