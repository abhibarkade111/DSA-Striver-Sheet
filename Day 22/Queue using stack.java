// Queue using Stack 

// Code 1:
// Optimised

import java.util.*;
public class Queue {
    // Define the data members(if any) here.
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    Queue() {
        // Initialize your data structure here.
    }

    void enQueue(int val) {
        // Implement the enqueue() function.
        st1.push(val);
    }

    int deQueue() {
        // Implement the dequeue() function.
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
            return st2.isEmpty()?-1:st2.pop();
        }
        return st2.isEmpty()?-1:st2.pop();
    }

    int peek() {
        // Implement the peek() function here.
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.isEmpty()?-1:st2.peek();
    }

    boolean isEmpty() {
        // Implement the isEmpty() function here.
        return st1.isEmpty()&&st2.isEmpty();
    }
}


// Code 2:

public class Queue {
    // Define the data members(if any) here.
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    Queue() {
        // Initialize your data structure here.
    }

    void enQueue(int val) {
        // Implement the enqueue() function.
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        st1.push(val);
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }

    int deQueue() {
        // Implement the dequeue() function.
        return st1.isEmpty()?-1:st1.pop();
    }

    int peek() {
        // Implement the peek() function here.
        return st1.isEmpty()?-1:st1.peek();
    }

    boolean isEmpty() {
        // Implement the isEmpty() function here.
        return st1.isEmpty();
    }
}