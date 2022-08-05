// Level Order Traversal
// Given Tree 
// Output : We need to return the each level nodes in the arraylist

// Approach : BFS (Queue)

// Code 

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = null;
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null){
            return ans;
        }
        q.offer(root);
        while(!q.isEmpty()){
            int count = q.size();
            list = new ArrayList<>();
            for(int i=0;i<count;i++){
                TreeNode curr= q.poll();
                list.add(curr.val);
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}

// CodeStudio 
// Different Problem 

// Code

public class Solution {
	public static int heightOfTheTree(int[] inorder, int[] levelOrder, int N){
		// Write your code here.
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,N-1));
        int pos[] = new int[N+1];
        for(int i=0;i<N;i++){
            pos[inorder[i]] = i;
        }
        int max=0;
        for(int i=0;i<N;i++){
            int curr = levelOrder[i];
            Node node = q.poll();
            int curPos = pos[curr];
            if(curPos>node.left){
                q.offer(new Node(node.height+1,node.left,curPos-1));
                max = Math.max(max, node.height+1);
            }
            
            if(curPos<node.right){
                q.offer(new Node(node.height+1, curPos+1, node.right));
                max = Math.max(max, node.height+1);
            }
        }
        return max;
	}
}

class Node
{
    int height;
    int left;
    int right;
    Node(int h, int l, int r){
        this.height = h;
        this.left = l;
        this.right = r;
    }
}