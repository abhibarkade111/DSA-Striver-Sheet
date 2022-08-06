// Symetric Binary Tree 
// left subtree mirror image is visible on right subtree
// travrse the left and right subtree of the tree
// if any condition return false 

// Approach :
// Find for each node and return true or false/*****************************************************************

public class Solution {

    public static boolean isSymetricHelp(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right){
        if(left==null || right==null) return left==right;
        if(!left.data.equals(right.data)) return false;
        return isSymetricHelp(left.left, right.right) && isSymetricHelp(left.right, right.left);
    }
    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        // Write your code here.
        return root==null || isSymetricHelp(root.left, root.right);
    }
}
