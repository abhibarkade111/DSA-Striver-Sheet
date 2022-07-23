// Maximum of minimum for every window size
// Input: arr=[3,3,4,2,4];
// Output: [4,3,3,2,2]

// Approach 1: Using Stack
// Cerate next smaller element index array
// create previous smaller element index array
// using stack we can easily find the next smaller and previous smaller elements
// accordingly add in the ans

// Time Complexity  - O(2n) + O(2n) + O(n) + O(n) + O(n) + O(n) => O(n)
// Space Compplexity - O(3n)

// Code:

public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        int ans[] = new int[n];
        int ps[] = new int[n];
        int ns[] = new int[n];
        Arrays.fill(ans, Integer.MIN_VALUE);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && a[st.peek()]>=a[i]){
                st.pop();
            }
            ps[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        
        while(!st.isEmpty()) st.pop();
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && a[st.peek()]>=a[i]){
                st.pop();
            }
            ns[i]= st.isEmpty()?n:st.peek();
            st.push(i);
        }
        
        for(int i=0;i<n;i++){
            ns[i] = ns[i]-ps[i]-1;
        }
        
        for(int i=0;i<n;i++){
            ans[ns[i]-1] = Math.max(ans[ns[i]-1],a[i]);
        }
        
        for(int i=n-2;i>=0;i--){
            ans[i] = Math.max(ans[i],ans[i+1]);
        }
        return ans;
    }
}

