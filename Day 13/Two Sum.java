// Two Sum Problem 
// As per Leetcode only sigle pair of element is exist in an array
// For eg. [2,7,9,8,4] and target = 9 so int the array only elemnts at index 0 and 1 can be considered to form a sum

// Approach 1: Brute Force
// Using Nested loop we can traverse array and accordingly we can found the index of the elemnts 
// Time Complexity:- O(n*n)
// Space Complexity:- O(n)


// Approach 2: Using HashMap
// Use HashMap store the array element and try to find or check element target-nums[i] is exist or not
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int sum=0;
        // int ans[] = new int[2];
        int first, second=0,f=0,s;
        HashMap<Integer, Integer> hm= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int rNum = target - nums[i];
            if(hm.containsKey(rNum)){
                int ans[] = {hm.get(rNum), i};
                return ans;
            }
            hm.put(nums[i],i);
        }
        return  null;
    }
}

// Time Complexity:- O(n)
// Space Complexity:- O(n)