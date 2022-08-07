// Floor in BST
// Floor in BST = Gratest value which is smaller than equal to the key

// Approach 1: Iterative

// Code:

public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        int ans=-1;
        TreeNode<Integer> curr = root;
        while(curr!=null){
            if(curr.data<=X){
                ans = curr.data;
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        return ans;
    }
}
