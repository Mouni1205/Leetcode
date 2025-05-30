/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode crnt = root;
        while(crnt!=null || !stack.empty()){
            while(crnt!=null){
                stack.push(crnt);
                crnt=crnt.left;
            }
            k--;
            crnt = stack.pop();
            if(k==0) return crnt.val;
            crnt = crnt.right;
        }
        return -1;
    }
}