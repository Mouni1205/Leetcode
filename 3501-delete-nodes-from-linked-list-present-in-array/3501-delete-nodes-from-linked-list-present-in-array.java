/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        //first add all the nums elements into set so its easy to check which number in list is equal to the 
        //number in the array
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);
        ListNode left = null;
        ListNode right = null;
        while(head!=null){
            //if array doesnt have the element then its either the start of our window
            //or we have to move the right 
            if(!set.contains(head.val)){
                if(left==null){
                    left = head;
                    right = head;
                }else{
                    right = head;
                }
            }else{
                if(right!=null){
                    right.next = head.next;
                }
            }
            head = head.next;
        }
        return left;
    }
}