// Construct Binary tree From Inorder and Preorder

// Approach:

// Use Map to store the inorder index to check which elements are left and which are right
// And Preorder to create nodes 

// Return Constructd tree

// Code:

/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution 
{
    public static TreeNode<Integer> buildTree(ArrayList<Integer> inorder, int inStart, int inEnd, ArrayList<Integer> preorder, int preStart, int preEnd, Map<Integer, Integer> hm){
        if(inStart>inEnd || preStart> preEnd) return null;
        TreeNode<Integer> root = new TreeNode(preorder.get(preStart));
        
        int inRoot = hm.get(root.data);
        int numsLeft = inRoot - inStart;
        
        root.left = buildTree(inorder, inStart, inRoot-1, preorder, preStart+1, preStart+numsLeft+1,hm );
        
        root.right = buildTree(inorder, inRoot+1, inEnd, preorder, preStart+numsLeft+1, preEnd, hm );
        
        return root;
    }
    public static TreeNode<Integer> buildBinaryTree(ArrayList<Integer>  inorder, ArrayList<Integer>  preorder) 
    {
        //    Write your code here.
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.size();i++){
            hm.put(inorder.get(i),i);
        }
        TreeNode<Integer> root = buildTree(inorder, 0, inorder.size()-1, preorder, 0, preorder.size()-1, hm);
        return root;
    }
}