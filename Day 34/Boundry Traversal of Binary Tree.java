// Boundry Traversal of Binary Tree 

// Approach 1: travrse left , Leaves and then right

// 1) Left: Travrse the left if left exist go in left else go on right
//    Do not add leaf nodes

// 2) Leaves: Use any travrsing technique to travrse the nodes and check if leaf nodes then add 

// 3) Right : Go on right from root add it any dataStructure and at the end add in ans in revrse order
//   Do not add leaf nodes

// Time Complexity - O(n)+O(n)+O(n)
// Space Complexity - O(n)

// Code:

public class Solution {
    public static boolean isLeaf(TreeNode root){
        if(root.left==null && root.right==null) return true;
        else return false;
    }
    public static void leftTree(TreeNode root, ArrayList<Integer> ans){
        TreeNode curr = root.left;
        while(curr!=null){
            if(!isLeaf(curr)) ans.add(curr.data);
            if(curr.left!=null) curr= curr.left;
            else curr = curr.right;
        }
        
    }
    public static void leaf(TreeNode root, ArrayList<Integer> ans){
        if(root==null) return;
        if(isLeaf(root)){
           ans.add(root.data);
           return;
        } 
        if(root.left!=null) leaf(root.left,ans);
        if(root.right!=null) leaf(root.right,ans);
    }
    public static void rightTree(TreeNode root,ArrayList<Integer> ans){
        TreeNode curr = root.right;
        Stack<Integer> st = new Stack<>();
        while(curr!=null){
            if(!isLeaf(curr)) st.push(curr.data);
            if(curr.right!=null) curr = curr.right;
            else curr = curr.left;
        }
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
    }
	public static ArrayList<Integer> traverseBoundary(TreeNode root){
		// Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        if(!isLeaf(root)) ans.add(root.data);
        leftTree(root,ans);
        leaf(root,ans);
        rightTree(root,ans);
        return ans;
	}
}