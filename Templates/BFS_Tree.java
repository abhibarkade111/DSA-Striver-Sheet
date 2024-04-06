public int BFS_Tree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = root.val;
        while(!q.isEmpty()){
            int size = q.size();
            boolean b = true;
            while(size-->0){
                TreeNode node = q.poll();
                if(b) ans = node.val;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                b=false;
            }
        }
        return ans;
    }