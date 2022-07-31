// Root to Node path
// Input : tree
// Output : ArrayList of path nodes

// Approache : Inorder recursive Traversal

// Time Complexity - O(n)
// Space Complexity - O(1)

// Code:

/*   
    Following is the Binary Tree node structure for referance:

    class TreeNode
    {
        int data;
        TreeNode left, right;
    
        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
*/
import java.util.*;
public class Solution {
    public static boolean getPath(TreeNode root, ArrayList<Integer> arr, int x){
        if(root==null){
            return false;
        }
        arr.add(root.data);
        if(root.data==x){
            return true;
        }
        
        if(getPath(root.left,arr,x) || getPath(root.right, arr,x)){
            return true;
        }
        arr.remove(arr.size()-1);
        return false;
    } 
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        // Write your code here..
        ArrayList<Integer> arr = new ArrayList<>();
        if(root==null) return arr;
        getPath(root,arr,x);
        return arr;
    }
}