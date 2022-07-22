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


public class Solution {
  public static int largestRectangle(ArrayList < Integer > heights) {
    // Write your code here.
      Stack<Integer> st = new Stack<>();
      int max=0;
      for(int i=0;i<=heights.size();i++){
          while(!st.isEmpty() &&(i==heights.size() || heights.get(st.peek())>=heights.get(i))){
              int height = heights.get(st.pop());
              int width = st.isEmpty()?i:i-st.peek()-1;
              max =Math.max(max, height*width);
          }
          st.push(i);
      }
      return max;
  }
}



