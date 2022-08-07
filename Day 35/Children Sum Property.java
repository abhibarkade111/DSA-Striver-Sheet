// Children Sum Property

// Children Sum Property:- root.val == root.left.val + root.right.val and we only increment the already exit value and at the end tree should follow the children some property

// Approach : O(n)
// We just update the node while going down if already smaller than the right+left then we can modify it as left.data = root.data and right.data = root.data

// Algo / Code

public class Solution {
    public static void changeTree(BinaryTreeNode < Integer > root) {
        // Write your code here.
        if(root==null) return;
        int child=0;
        if(root.left!=null) child+= root.left.data;
        if(root.right!=null) child+= root.right.data;
        
        if(child>= root.data)  root.data = child;
        else{
            if(root.left!=null) root.left.data = root.data;
            if(root.right!=null) root.right.data = root.data;
        }
        
        changeTree(root.left);
        changeTree(root.right);
        int tot=0;
        if(root.left!=null) tot+= root.left.data;
        if(root.right!=null) tot+= root.right.data;
        if(root.left!=null || root.right!=null) root.data = tot;
    }
}

