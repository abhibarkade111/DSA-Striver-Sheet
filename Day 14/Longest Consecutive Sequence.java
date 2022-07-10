// Find the longest size having consecutive sequence
// Approach 1: Sort the array and using counter find the max count;
// Time Complexity - o(NlogN + N)
// Space Complexity - O(1)

// Approach 2: Using HashSet 
// Algorithm :- 1) Add all elements to the HashSet
//              2) Check whether ele-1 exist or not if exist then skip and move to next elements
//              3) if not exists then use while loop and check ele++ is exist and count the elements 
//              4) Return the max Count

// Time Complexity :- O(3N)
// Space Complexity :- O(N)

// Code :

public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int res=0;
        for(int num : set){
            if(!set.contains(num-1)){
                int curr = num;
                int ans=1;
                while(set.contains(curr+1)){
                    ans++;
                    curr++;
                }
                
                res = Math.max(res, ans);
            }
        }
        return res;
}