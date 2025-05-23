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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root,targetSum,result,new ArrayList<>());
        return result;
    }
    public void dfs(TreeNode root,int targetSum,List<List<Integer>> result,List<Integer> crnt){
        if(root==null) return;
        crnt.add(root.val);
        if(root.left==null&&root.right==null&&root.val==targetSum){  
            result.add(new ArrayList<>(crnt));
        }
        dfs(root.left,targetSum-root.val,result,crnt);
        dfs(root.right,targetSum-root.val,result,crnt);
        crnt.remove(crnt.size()-1);
    }
}