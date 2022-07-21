// Next Smaller Element 
// Input : array 
// Output : Next smaller element for each element

// Approach 1: Brute force
// Check for the each element which is the smaller element

// Approach 2: Use Stack

// Time Complexity - O(2n)
// Space Complexity - O(n)

// Code:

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int ansArr[] = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()>=arr.get(i)){
                st.pop();
            }
            if(st.isEmpty()) ansArr[i]=-1;
            else ansArr[i] = st.peek();
            st.push(arr.get(i));
        }
        for(int i: ansArr) ans.add(i);
        return ans;
    }
}