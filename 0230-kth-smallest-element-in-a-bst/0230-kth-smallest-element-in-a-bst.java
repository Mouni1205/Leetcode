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
       int pair[]= new int[2];
       helper(root,k,pair);
       return pair[1];
    }
    public void helper(TreeNode root,int k,int pair[]){
        if(root==null) return;
        helper(root.left,k,pair);
        pair[0]++;
        if(pair[0]==k){
            pair[1]=root.val;
            return;
        }
        helper(root.right,k,pair);
    }
}