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