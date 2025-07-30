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
    public int getDecimalValue(ListNode head) {
        int len=0;
        int result = 0;
        ListNode crnt = head;
        while(crnt!=null){
            len++;
            crnt = crnt.next;
        }
        crnt = head;
        while(crnt!=null){
            --len;
            if(crnt.val==1){
                result+=Math.pow(2,len);
            }
            crnt = crnt.next;
        }
        return result;
    }
}