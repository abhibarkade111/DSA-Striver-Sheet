// Preorder Inorder Postorder Traversal in one Traversal
// Input: 1 2 3 -1 -1 -1  6 -1 -1
// Output:
// 2 1 3 6 
// 1 2 3 6 
// 2 6 3 1

// Approach 1: Using Stack 
// three Conditions: if num==1 then add it in inorder and num++ and if left of it is exixst then add it to the stack 
//                   if num==2 then add it in preorder and num++ and if right of it is exixst then add it to the stack
//                   if num==1 then add it in postorder 

// Code :

/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/

class Pair{
    int key;
    BinaryTreeNode<Integer> node;
    Pair(BinaryTreeNode<Integer> node, int key){
        this.key = key;
        this.node = node;
    }
}
public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));
        while(!st.isEmpty()){
            Pair p = st.pop();
            int l = p.key;
            BinaryTreeNode<Integer> temp = p.node;
            if(l==1){
                inorder.add(temp.data);
                p.key++;
                st.push(p);
                if(temp.left!=null){
                    st.push(new Pair(temp.left,1));
                }
            }
            else if(l==2){
                pre.add(temp.data);
                p.key++;
                st.push(p);
                if(temp.right!=null){
                    st.push(new Pair(temp.right,1));
                }
            }
            else{
                post.add(temp.data);
            }
        }
        ans.add(pre);
        ans.add(inorder);
        ans.add(post);
        return ans;
    }
}
