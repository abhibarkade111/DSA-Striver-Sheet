// Pair Sum In BST 

// Given Binary tree and target sum we need to check pair of the nodes of this sum is present or not if present return true else return false

// Apprach 1: Do Inorder Traversal then we will get a sorted array      
//            Now do the two pointer approach to find the two sum
//            return true if exit else return false

// Time Complexity - O(n)+O(n)
// Space Complexity - O(n)

// Code:

public class Solution {
    public static void inorder(BinaryTreeNode root, ArrayList<Integer> arr){
        if(root==null) return;
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
	public static boolean pairSumBst(BinaryTreeNode root, int k) {
		// Write your code here.
        if(root==null || (root.left==null && root.right==null)) return false;
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root ,arr);
//         System.out.println("size="+arr.size());
//         System.out.println(arr);
        int low = 0;
        int high = arr.size()-1;
        while(low<high){
//             System.out.println(arr.get(low)+" "+arr.get(high));
            if((arr.get(low)+arr.get(high))==k) return true;
            else if((arr.get(low)+arr.get(high))<k) low++;
            else high--;
        }
        return false;
	}
}

// Approach 2: BST Iterator

// BST Iterator will be return us incerse elemnt and also if we do this in revrse order then it will return decresing elements so we now able to use the two ppointer appaoch on it

// Time Complexity - O(n)
// Space Complexity - O(1)

// Code:

class BSTI{
    Stack<TreeNode> st = new Stack<>();
    boolean iR = false;
    
    BSTI(TreeNode root, boolean r){
        this.iR = r;
        pushAll(root);
    }
    
    public boolean hasNext(){
        return !st.isEmpty();
    }
    
    public int next(){
        TreeNode temp = st.pop();
        if(iR) pushAll(temp.left);
        else pushAll(temp.right);
        return temp.val;
    }
    
    public void pushAll(TreeNode root){
        while(root!=null){
            st.push(root);
            if(iR) root = root.right;
            else root = root.left;
        }
    }
    
    
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTI l = new BSTI(root, false);
        BSTI r = new BSTI(root, true);
        
        int low = l.next();
        int high = r.next();
        System.out.println(low+" "+high);
        while(low<high){
            System.out.println(low+" "+high);
            if(low+high==k) return true;
            else if(low+high<k && l.hasNext()) low = l.next();
            else if(r.hasNext()) high = r.next();
        }
        return false;
        
    }
}

