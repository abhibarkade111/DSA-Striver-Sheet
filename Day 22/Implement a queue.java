// Implement a queue
// Implement a queue using array

// Code:

public class Queue {
    int arr[] = new int[5000];
    int front;
    int rear;
    Queue() {
        // Implement the Constructor
        front =0;
        rear=0;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function
        if(front==rear) return true;
        return false;
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        arr[rear] = data;
        rear++;
    }

    int dequeue() {
        // Implement the dequeue() function
        if(rear==front) return -1;
        int data = arr[front];
        front++;
        if(front==rear){
            front=0;
            rear=0;
        }
        return data;
    }

    int front() {
        // Implement the front() function
        if(front==rear){
            return -1;
        }
        return arr[front];
    }

}
