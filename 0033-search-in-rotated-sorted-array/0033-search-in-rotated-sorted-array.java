class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target) return mid;
            //if the left half is sorted now we have to decide whether to move left or right 
            if(nums[mid]>=nums[low]){
                //if the target is more than mid or the left most element is greater than target 
                if(target>nums[mid] || target<nums[low]) low = mid+1;
                 //if the target is more than left most element but less than the middle then we have to search in the left hal
                else high = mid-1;
            }
            //if the left half is not sorted then the right half must be sorted so now we decide where to move
            else {
                //if the target is less than mid or greater than the rightmost element then search in the left half
                if (target < nums[mid] || target > nums[high]) high = mid - 1;
                //else search in the right half
                else low = mid + 1;
            }
        }
        return -1;
    }
}
