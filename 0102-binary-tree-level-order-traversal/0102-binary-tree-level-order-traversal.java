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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            
            while(size-->0){
                TreeNode crnt = queue.poll();
                if(crnt.left!=null) queue.offer(crnt.left);
                 if(crnt.right!=null) queue.offer(crnt.right);
                 list.add(crnt.val);
            }
            result.add(list);

        }
        return result;

    }
}