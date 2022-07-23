// Sliding Window maximum
// Input : arr = [1,3,-1,-3,5,3,6,7] and k=3
// output: [3,3,5,5,6,7]

// Approach 1: Brute Forece

// Check for eack window wchich is largest
// return ans

// Time Complexity - O(KN)
// Space Complexity - O(1)

// Approach 2: Deque Data Structure
// Insert greater elements in the front of queue and check if cross the window remove it from the deque
// while removing smaller elements from the dequeu remove from the back of the queue
// return ans

// Time Complexity - O(2n)
// Space Complexity - O(n)

// Code:


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int ri=0;
        
        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peek()==i-k){
                dq.poll();
            }
            while(!dq.isEmpty()  && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                ans[ri++] = nums[dq.peek()];
            }
        }
        return ans;
    }
}



