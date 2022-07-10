// Find the quadraple which sum is equal to given target
// Approach 1: Sort Array + Use three Pointer + Do Binary Serach on Remaining array to find the Elements
// Time Complexity :- O(N^3*logN + NlogN)
// Space Complexity :- O(1)

// Approach 2: Sort Array + Use Two Pinter + Find the Two_sum i.e Reamining Target in remaining array
// Time Complexity :- O(N^3)
// Space Complexity :- O(1)

// Code- Approach 2

 public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null && nums.length==0){
            return res;
        }
        Arrays.sort(nums);
        // if(target<0 && nums[0]>0) return res;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long target2 = (long)target-(long)nums[j]-(long)nums[i];
                int front = j+1;
                int back = n-1;
                while(front<back){
                    long twoSum = (long)nums[front]+(long)nums[back];
                    if(twoSum<target2) front++;
                    else if(twoSum>target2) back--;
                    else{
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[front]);
                        quad.add(nums[back]);
                        res.add(quad);
                        
                        while(front< back && nums[front]==quad.get(2)) front++;
                        while(front<back && nums[back]==quad.get(3)) back--;
                    }
                }
                
                while(j+1<n && nums[j]==nums[j+1]) j++;
            }
            while(i+1<n && nums[i]==nums[i+1]) i++;
        }
        return res;
 }
