// Bottom View of Binary Tree 
// Input : Given Binary tree
// Output : return nodes which are visible from bottom

// Approach 1: Using LevelOrder traversal and add all the node in map by line i.e which line the node is present i.e suppose new node on bottom side on straight line is found then we can add it to the map and it would will be overwritten
// at the end traverse the map and add all the values of map to the ans 
// Use TreeMap because keys are sorted in the treeMap

// Time Complexity - O(2n)
// Space Complexity  - O(2n)

// Code:

/*********************************************

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

*********************************************/
class Pair{
    int key;
    BinaryTreeNode node;
    Pair(int key, BinaryTreeNode node){
        this.key = key;
        this.node = node;
    }
}
public class Solution {
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
         // Write your code here. 
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        Map<Integer,Integer> hm = new TreeMap<>();
        while(!q.isEmpty()){
            Pair p = q.poll();
            int l = p.key;
            BinaryTreeNode temp = p.node;
            hm.put(l,temp.val);
            if(temp.left!=null){
                q.add(new Pair(l-1,temp.left));
            }
            if(temp.right!=null){
                q.add(new Pair(l+1,temp.right));
            }
        }
        for(int key : hm.keySet()){
            ans.add(hm.get(key));
        }
        return ans;
    }
}

// GFG Solution

// Code:

//{ Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}



class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Solution ob = new Solution();
			    ArrayList <Integer> res = ob.bottomView(root);
			    for (Integer num : res) System.out.print (num + " ");
		     	System.out.println();
	        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<Node> q = new LinkedList<>();
        Map<Integer, Integer> hm = new TreeMap<>();
        root.hd=0;
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            int hd = temp.hd;
            hm.put(hd,temp.data);
            if(temp.left!=null){
                temp.left.hd = hd-1;
                q.add(temp.left);
            }
            if(temp.right!=null){
                temp.right.hd = hd+1;
                q.add(temp.right);
            }
        }
        for(int key : hm.keySet()){
            ans.add(hm.get(key));
        }
        return ans;
    }
}

