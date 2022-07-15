// Subset-II
// We need to return all possible subsets without duplicates

// Approach 1:
// Use Pick and not to pick techinique i.e recursion and generate all possible subsets 
// add it to solution 
// Use set or any other data structure to check the duplicates

// Approach 2:
// Use Data structure to store the generated subsets 
// Do not call same elements again because it will add same subsets

// Time Complexity-  O(2^N*N)
// Space Complexity - O(2^N)


// Code:
class Solution {
    public void func(int ind,List<Integer> ds,int[] nums,List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            func(i+1,ds,nums,ans);
            ds.remove(ds.size()-1);
            
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans  = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        func(0,list,nums,ans);
        return ans;
    }
}