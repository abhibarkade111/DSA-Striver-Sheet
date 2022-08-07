// Convert Sorted Array to Binary Search Tree

// As we know that the left elements are smaller than the root and right elemnents are greater than the root 
// We need to balnced binary tree i.e no any node have the diff between right and right subtree is more than one

// Approch: 
// mid will be the root and recursively call the function for the left and the right subtree and check update the start and the end index accordingly add the left and the right 

// Code:

class Solution {
    public TreeNode buildTree(int nums[], int s, int e){
        int mid = s+e>>1;
        if(s>e) return null;
        TreeNode root= new TreeNode(nums[mid]);
        root.left = buildTree(nums, s, mid-1);
        root.right = buildTree(nums, mid+1,e);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }
}

