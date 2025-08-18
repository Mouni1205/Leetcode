class Solution {
    public int findDuplicate(int[] nums) {
        //value at any index of the array represents the link 
        //0-1 1-3 2-4 3-2 4-2
        //first find the point where slow and fast meet and from that point move them at the same speed and 
        //the point where they meet again is the answer
        // 2(p+c-x) = p+2c-x -> to prove p=x to prove the second part 

        //step 1 - find the start of the cycle 

        int fast = 0, slow = 0;

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow==fast) break;
        }

        //step 2 - find the ans: p=x 
        slow = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;

    }
}