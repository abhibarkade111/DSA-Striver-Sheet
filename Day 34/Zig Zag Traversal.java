// Zig zag Travrsal 

// Approach : Maintain flag for checking which condition i.e Left to right or Right to Left
// add accordingly in the ans 
// return solution

// Time Complxity - O(n+)
// Space Complexity - O(n)

// Code:

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean ltr = true;
        List<List<Integer>> ans=  new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                if(ltr) arr.add(temp.val);
                else arr.add(0,temp.val);
                
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            ans.add(arr);
            ltr=!ltr;
        }
        return ans;
    }
}


// CodeStudio

public class Solution {
	public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
		// Write your code here!
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean ltr=true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> arr = new ArrayList<>();
            for(int i=0;i<size;i++){
                BinaryTreeNode<Integer> temp = q.poll();
                arr.add(temp.data);
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            if(ltr){
                for(int i: arr) ans.add(i);
            }
            else{
                for(int i=arr.size()-1;i>=0;i--) ans.add(arr.get(i));
            }
            ltr = !ltr;
        }
        return ans;

	}
}
