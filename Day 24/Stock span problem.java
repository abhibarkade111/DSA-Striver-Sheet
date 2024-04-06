// Stock Span Problem
// Input
// ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
// [[], [100], [80], [60], [70], [60], [75], [85]]
// Output
// [null, 1, 1, 1, 2, 1, 4, 6]

// Approach 1: Using Stack
// Store the price and current span in the stack
// intialize the count=1
// while the price in the stack is less than equal to the current price then increase the counter by pppoing the element and add span of the ppoped element from the stack
// return count

// Time Complexity: O(2n)
// Space Complexity: O(n)

// Code:

class StockSpanner {
    
    static class Pair{
        int val;
        int span;
        Pair(int val,int span){
            this.val = val;
            this.span = span;
        }
    }
    
    Stack<Pair> st;

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int count=1;
        while(!st.isEmpty() && st.peek().val<=price){
            count+= st.pop().span;
        }
        st.push(new Pair(price,count));
        return count;
    }
    
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */