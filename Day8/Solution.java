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
    public int sumRootToLeaf(TreeNode root) {
        return RootToLeaf(root, new StringBuilder());
    }
    
    int RootToLeaf( TreeNode node, StringBuilder sb )
    {
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
        {
            sb.append(node.val);
            return Integer.parseInt(sb.toString(), 2);
        }
        
        sb.append(node.val);
        int lAns = RootToLeaf( node.left, new StringBuilder(sb) );
        int rAns = RootToLeaf( node.right, new StringBuilder(sb) );
        return lAns + rAns;
    }
   
}