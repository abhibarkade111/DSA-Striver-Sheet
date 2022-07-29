// Vertical Order Traversal
// Input : Given Tree
// Output : Return ans arrayList

// Approach 1: Traverse the tree using level order traversal also maintain the vertical line number 
// At the end trevrse the map add list to the ans
// return ans

// Time Complexity - O(2n)
// Space Complexity - O(2n)

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

class Pair{
    int line;
    TreeNode<Integer> node;
    Pair(TreeNode<Integer> node, int line){
        this.node = node;
        this.line = line;
    }
}
public class Solution 
{
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Map<Integer, ArrayList<Integer>> hm = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int line = p.line;
            TreeNode<Integer> temp = p.node;
            if(!hm.containsKey(line)){
                hm.put(line, new ArrayList<>());
            }
            hm.get(line).add(temp.data);
            if(temp.left!=null){
                q.offer(new Pair(temp.left,line-1));
            }
            if(temp.right!=null){
                q.offer(new Pair(temp.right, line+1));
            }
        }
        for(int key: hm.keySet()){
            for(int i : hm.get(key)){
                ans.add(i);
            }
        }
        return ans;
    }
}

// Code: Leetcode

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    int line;
    int level;
    TreeNode node;
    Pair(TreeNode node,int line, int level){
        this.node = node;
        this.line = line;
        this.level = level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Map<Integer,TreeMap<Integer,PriorityQueue<Integer>>> hm = new TreeMap<>();
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(root,0,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int line = p.line;
            int level = p.level;
            TreeNode temp = p.node;
            
            if(!hm.containsKey(line)){
                hm.put(line, new TreeMap<>());
            }
            
            if(!hm.get(line).containsKey(level)){
                hm.get(line).put(level, new PriorityQueue<>());
            }
            
            hm.get(line).get(level).offer(temp.val);
            
            if(temp.left!=null){
                q.offer(new Pair(temp.left,line-1,level+1));
            }
            if(temp.right!=null){
                q.offer(new Pair(temp.right,line+1,level+1));
            }
        }
        
        for(int key : hm.keySet()){
            ans.add(new ArrayList<>());
            for(int key1 : hm.get(key).keySet()){
                while(!hm.get(key).get(key1).isEmpty()){
                    ans.get(ans.size()-1).add(hm.get(key).get(key1).poll());
                }
            }
        }
        return ans;
        
        
       
    }
}
