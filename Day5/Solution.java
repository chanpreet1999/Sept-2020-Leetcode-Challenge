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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
     
        List<Integer> ans1 = new ArrayList();
        List<Integer> ans2 = new ArrayList();
        inOrder(root1,ans1);
        inOrder(root2, ans2);
        
        return merge(ans1, ans2);
    }
    void inOrder( TreeNode root, List<Integer> ans )
    {
        if(root == null)
            return;
        
        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }
    List<Integer> merge( List<Integer> l1, List<Integer> l2 )
    {
        List<Integer> ans = new ArrayList<>();
        int size1 = l1.size(), size2 = l2.size();
        int i = 0, j = 0;
        
        while(i < size1 && j < size2)
        {
            if( l1.get(i) < l2.get(j) )
            {
                ans.add( l1.get(i) );
                i++;
            }
            else
           {
            ans.add( l2.get(j) );
            j++;
          }       
      }
    
        while( i < size1)
            ans.add( l1.get(i++) );
        while( j < size2)
            ans.add( l2.get(j++) );
        return ans;
    }
}