// Largest Rectangle in Histogram  

// Approach 1: Brute Force
// Calculate for each height leftMin and rightMin by traversing left array and right array
// Accordingly calculate the max Area and return

// Time Complexity - O(N*N)
// Space Complexity - O(1)

// Approach 2: Using Stack 
// Calculate the left smaller elemnt and store all index in array
// Same calculate right smaller element

// Again trvarse the height array and calculate the area i.e height[i]*(rightArr[i]-leftArr[i]+1)
// return max Area

// Time Complexity - O(4n) => O(n)
// Space Complexity - O(n)+O(2n)

// Code:

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int leftArr[] = new int[heights.length];
        int rightArr[] = new int[heights.length];
        int max=0;
        
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()) leftArr[i] = 0;
            else leftArr[i] = st.peek()+1;
            st.push(i);
        }
        
        while(!st.isEmpty()){
          st.pop();  
        } 
        
        for(int i=heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()) rightArr[i] = heights.length-1;
            else rightArr[i] = st.peek()-1;
            max = Math.max(max, (rightArr[i]-leftArr[i]+1)*heights[i]);
            st.push(i);
        }
        return max;
    }
}

// Appraoch 3: Use Single Stack 
// While popping the element from the stack check for each element in the stack which is popped

// Time Complexity: O(2n)
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

