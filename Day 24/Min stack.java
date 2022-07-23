// Min Stack 
// need to return minimum element from the stack in O(1)

// Approach 1: Use Pair while storing elements in stack pair contains element and minimum element
// Time Complexity - O(1)
// Space Complexity - O(2n)

// code:

public class Solution {
    static class Pair{
        int val,mini;
        Pair(int val,int mini){
            this.val = val;
            this.mini = mini;
        }
    }
    static class MinStack {
       Stack<Pair> st;
        int min = Integer.MAX_VALUE;
        // Constructor
        MinStack() {
            // Write your code here.
            st=  new Stack<>();
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            // Write your code here.
            if(st.isEmpty()){
                min = num;
                st.push(new Pair(num,min));
            }
            else{
                if(st.peek().mini<num){
                    min = st.peek().mini;
                    st.push(new Pair(num,min));
                }
                else{
                    min = num;
                    st.push(new Pair(num,min));
                }
            }
            
            
        }

        // Function to remove the top element of the stack.
        int pop() {
            // Write your code here.
            if(st.isEmpty()) return -1;
            else{
                return st.pop().val;
            }
            
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            // Write your code here.
            if(st.isEmpty()) return -1;
            else{
                return st.peek().val;
            }
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            // Write your code here.
            if(st.isEmpty()) return -1;
            else{
                return st.peek().mini;
            }
        }
    }
}


// Approach 2: Use stack and using formula we enetr element
// while pushing if new element is smaller then - 2*val-mini
// while popping the element is from the stack and the element is less than new element then - 2*mini-val

// Time Complexity - O(1)
// Space Complexity - O(n)

// Code:
class MinStack {
    Stack<Long> st = new Stack<>();
    Long mini;
    public MinStack() {
        mini = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        Long value = Long.valueOf(val);
        if(st.isEmpty()){
            st.push(value);
            mini = value;
        }
        else{
            if(value<mini){
                st.push(2*value-mini);
                mini = value;
            }
            else{
                st.push(value);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        Long val = st.pop();
        if(val<mini){
            mini = 2*mini-val;
        }
    }
    
    public int top() {
        Long val = st.peek();
        if(val<mini){
            return mini.intValue();
        }
        return val.intValue();
    }
    
    public int getMin() {
        return mini.intValue();   
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */