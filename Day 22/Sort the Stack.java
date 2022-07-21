// Sort the Stack 

// Approach : Recursion

// Code:

public class Solution {
    public static void sortedInsert(Stack<Integer> s, int num){
        if(s.isEmpty() || (!s.isEmpty() && s.peek()<num)){
            s.push(num);
            return;
        }
        int n = s.peek();
        s.pop();
        sortedInsert(s,num);
        s.push(n);
    }

	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
        if(stack.isEmpty()) return;
        int num = stack.peek();
        stack.pop();
        sortStack(stack);
        sortedInsert(stack,num);
	}

}