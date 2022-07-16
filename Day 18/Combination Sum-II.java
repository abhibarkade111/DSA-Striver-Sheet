// Combination Sum-II 
// Input : [1,1,1,2,2] ans sum=4 => [[1,1,2],[2,2]]
// Dupliactes are Not allowed

// Approach 1: Brute Force 
// Find the all the subsets and using hashset store only unique subsets 
// return unique subsets

// Approach 2: Optimal Approach
// Do not call the same function for the same value i.e starting or any position of value must be unique if there is same calls must ignore this cases

// Time Complexity   - O(2^N + K)
// Space Complexity - O(k * x)

// Code:

class Solution {
    public void findCombo(int ind, int target, int arr[], List<List<Integer>> ans, List<Integer> ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            ds.add(arr[i]);
            findCombo(i+1,target-arr[i],arr,ans,ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCombo(0,target,candidates,ans,new ArrayList<>());
        return ans;
    }
}