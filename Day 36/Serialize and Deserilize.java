// Serialize and Desilize

// Serialize - Convert nodes into the string 
// Deserilize  - Convert String to the Tree

// Approach 1: We can Solve it using any traversal

// We Use Level Order Travrsal
// Append nodes as a string if null append '#'
// Pass String to the Deserilize 
// Convert string Tree using Level Order Traversal

// Time Complexity - O(n)
// Space Complexity - O(n)


// code:

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null){
                res.append("n ");
                continue;
            } 
            res.append(node.val+" ");
            q.add(node.left);
            q.add(node.right);
            
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String values[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for(int i=1;i<values.length;i++){
            TreeNode parent = q.poll();
            if(!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if(!values[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}