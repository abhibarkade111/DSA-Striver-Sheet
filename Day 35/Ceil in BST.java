// Ceil in BST 

// Ceil in BST - Lowest value which is greater than equal to key

// Code:

public class Solution {

    public  static int findCeil(TreeNode<Integer> node, int x) {
        TreeNode<Integer> curr = node;
        int ceil=-1;
        while(curr!=null){
            if(curr.data==x) return curr.data;
            if(curr.data>x){
                ceil = curr.data;
                curr = curr.left;
            }
            else{
                curr=curr.right;
            }
        }
        return ceil;
    }
}