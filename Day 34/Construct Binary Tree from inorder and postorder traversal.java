// Construct Binary Tree from inorder and postorder traversal

// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]

// Approach 1: Same as the inorder and preorder but here is given the postorder so the root will be at the end
// so maintain the elements according to it and it to ans

// Code:

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
    public TreeNode buildTree(int inorder[], int is, int ie, int postorder[], int ps, int pe, HashMap<Integer, Integer> hm){
        if(ps>pe || is>ie) return null;
        
        TreeNode root = new TreeNode(postorder[pe]);
        int inRoot = hm.get(postorder[pe]);
        int numsleft = inRoot-is;
        
        root.left = buildTree(inorder,is, inRoot-1, postorder, ps, ps+numsleft-1, hm);
        root.right = buildTree(inorder, inRoot+1, ie, postorder, ps+numsleft, pe-1,hm);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, hm);
        
    }
}
