// Top view of Binary Tree 
// Input : Given tree
// Output : return the nodes which are visible from top

// Approach : Same as the bottom view i.e travrse using the level order traversal and add the node on each line only once i.e when node is not present in the map then only add to the map
// Travrse the map and return the ans

// Time Complexity - O(n)
// Space Complexity - O(2n)

// Code:

/************************************************************

    Following is the TreeNode class structure:

    class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

************************************************************/
class Pair{
    int key;
    BinaryTreeNode node;
    Pair(int key, BinaryTreeNode node){
        this.key = key;
        this.node = node;
    }
}
public class Solution {
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		// Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Map<Integer, Integer> hm = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int l = p.key;
            BinaryTreeNode temp = p.node;
            if(!hm.containsKey(l)) hm.put(l,temp.val);
            if(temp.left!=null) q.offer(new Pair(l-1,temp.left));
            if(temp.right!=null) q.offer(new Pair(l+1,temp.right));
        }
        for(int key: hm.keySet()){
            ans.add(hm.get(key));
        }
        return ans;
	}
}