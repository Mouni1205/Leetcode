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
    public int goodNodes(TreeNode root) {
        int count[]=new int[1];
        dfs(root,count,root.val);
        return count[0];
    }
    public void dfs(TreeNode root,int count[],int max){
        if(root==null) return;
            if(root.val>=max){
                count[0]+=1;
                max = Math.max(root.val,max);
            }
            dfs(root.left,count,max);
            dfs(root.right,count,max);
    }
}