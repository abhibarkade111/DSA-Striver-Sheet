// Implement stack Uisng Arrays 

// Code:


public class Stack {
    int arr[];
    int top;
    int size;
    Stack(int size){
        this.size = size;
        arr = new int[size];
        top=-1;
    }
    void push(int num) {
        // Write your code here.
        if(top<size){
            top++;
            arr[top] = num;
        }
    }
    int pop() {
        // Write your code here.
        if(top!=-1){
            int ans = arr[top];
            top--;
            return ans;
        }
        return -1;
    }
    int top() {
        // Write your code here.
        if(top!=-1){
            return arr[top];
        }
        return -1;
    }
    int isEmpty() {
        // Write your code here.
        if(top==-1){
            return 1;
        }
        else{
            return 0;
        }
    }
    int isFull() {
        // Write your code here.
        if(top==size){
            return 1;
        }
        else{
            return 0;
        }
    }
}
