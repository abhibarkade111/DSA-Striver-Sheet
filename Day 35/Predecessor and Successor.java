// Predecessor and Successor

// Predecessor - prev node of key in inorder Traversal
// Successor - next node of key in inorder traversal

// Approach 1:
// Do the Inorder travrsal it will be sorted
// Find the predecessor and successor

// Time Complexity  - O(n*n)
// Space Complexity - O(n)

// Approach 2: Travrse the inorder and find the next and prev node

// Time Complexity - O(n)
// Space Complexity - O(1)

// Approach 3: Binary Search Tree Property
// go according to the left and right node and return ans

// Time Complexity - O(h)
// Space Complexity -  O(1)


// Code

class GfG
{
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       // add your code here
       p.pre=null;
       s.succ = null;
       Node curr= root;
       while(curr!=null){
           if(curr.data>key){
               s.succ = curr;
               curr = curr.left;
           }
           else if(curr.data<key){ 
               p.pre = curr;
               curr = curr.right;
           }
          else{
              if(curr.left!=null){
                  p.pre = curr.left;
              }
              if(curr.right!=null){
                  s.succ = curr.right;
                //   curr = curr.right;
              }
              curr = curr.left;
            //   break;
          }
       }
    }
}


// Code:

public class Solution {
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		// Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        int p=-1,s=-1;
        BinaryTreeNode<Integer> temp = root;
        while(temp!=null){
            if(temp.data<key){
                p = temp.data;
                temp = temp.right;
            }
            else{
                temp = temp.left;
            }
        }
        temp = root;
        while(temp!=null){
            if(temp.data<=key){
                temp = temp.right;
            }
            else{
                s = temp.data;
                temp = temp.left;
            }
        }
        ans.add(p);
        ans.add(s);
        return ans;
	}
}