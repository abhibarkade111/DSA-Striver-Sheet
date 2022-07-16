// Combination Sum
// Input: [2,3,6,7] and target=7 => [[2,2,3],[7]]
// As in the Given problem we are able to pick the Any element any number of time to make the sum=target
// Approach : Use Recursion
//  Use Pick and not pick technique but until target>= arr[ind] call the same index 
//                                            target< arr[ind] call the ind+1

// Time Complexity - O(2^target + K)
// Space Complexity - O(K*x)

// Code:

class Solution {
    public void findCombinations(int ind,int arr[], int target, List<List<Integer>> ans, List<Integer> ds){
        if(arr.length==ind){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        if(target>=arr[ind]){
            ds.add(arr[ind]);
            findCombinations(ind,arr,target-arr[ind],ans,ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(ind+1,arr,target,ans,ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}
