// Kth Smallest Element from BST 

// Approach 1: Do inorder travrsal and maintain the counter
//             if(count==k) return element

// Time Complexity - O(n)
// Space Complexity - O(n)


// Apparoch 2: Morris Order Travrsal 
// Inorder and Iterative using stack take the space complexity so we choose the morris order travrsal


// Time Complexity - O(n)
// Space Complexity - O(1)


// code:

public class Solution 
{

	public static int kthSmallest(TreeNode<Integer> root, int k) 
	{
        TreeNode<Integer> curr = root;
        int i=0;
        while(curr!=null){
            if(curr.left==null){
                i++;
                if(i==k){
                    return curr.data;
                }
                curr = curr.right;
            }
            else{
                TreeNode<Integer> prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev = prev.right;
                }
                
                if(prev.right==null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    i++;
                    if(i==k){
                        return curr.data;
                    }
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return -1;
	}

}