// Construct Binary Search Tree from Preorder Traversal
// Input: preorder = [8,5,1,7,10,12]
// Output: [8,5,10,1,7,null,12]

// Approach 1: Trevrse the array for each node
// According to the bst properties smaller attach to the root left and greater attached to the root right

// Time Complexity - O(n*n)
// Space Complexity - O(n)

// Approach 2: Given Preorder after sorting the preorder we will get the inorder and from preorder and inorder we can able to build a unique binary tree

// Time Complexity - O(nlogn)
// Space Complexity - O(n)

// Approach 3: Optimal Approach
// Using Upper bound we can build the BST 
// So element is less than the upper bound should be left and each time while going left we update the upper bound as the Max value
// initially the upper bound is the Integer.MAX_VALUE

// Code:

class Solution {
    public TreeNode buildT(int A[], int bound, int i[]){
        if(i[0]==A.length || A[i[0]]>bound) return null;
        TreeNode root = new TreeNode(A[i[0]++]);
        root.left = buildT(A,root.val, i);
        root.right = buildT(A,bound, i);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildT(preorder, Integer.MAX_VALUE, new int[]{0});
    }
}