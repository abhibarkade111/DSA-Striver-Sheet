// Copy List with Random Pointer
// i.e List having two pointer one is next and other is Random
// So Random will point anywhere we need to create a same copy of the linkedList and return it 

// Approach 1: use HashMap
// steps 1: 1) Store all the Node and corrssponding new node i.e copy in the hashMap 
//          2) While second time traversing get the Node from map and asign the next and random of the original node to the copy node

// Time Complexity - o(2N)
// Space Complexity - O(N)

// Code :

/*************************************************************

    Following is the LinkedListNode class structure

    class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }

*************************************************************/

public class Solution {
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		// Write your code here.
        HashMap<LinkedListNode<Integer>, LinkedListNode<Integer>> hm = new HashMap<>();
        LinkedListNode<Integer> iter = head;
        while(iter!=null){
            LinkedListNode<Integer> copy = new LinkedListNode<Integer>(iter.data);
            hm.put(iter, copy);
            iter = iter.next;
        }
        iter = head;
        while(iter!=null){
           LinkedListNode<Integer> copy = hm.get(iter);
            copy.next = iter.next;
            copy.random = iter.random;
            iter = iter.next;
        }
        return hm.get(head);
	}
}



// Approach 2: Withoout using a Extra space
// Algorithm : 1) create copy and of node and insert in after the original Node at fist step don't assign the random pointer
//             2) Now assign the random pointer
//             3) in third time travrsing now recover the original and seperate the copy linkedList and return it

// Time Complexity - O(N)+O(N)+O(N)=>O(N)
// Ṣpace Complexity - O(1)

// Code :

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node iter = head;
        Node front = head;
        while(iter!=null){
            front = iter.next;
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;
            iter = front;
        }
        
        iter = head;
        while(iter!=null){
            if(iter.random!=null){
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }
        
        iter = head;
        Node dummy= new Node(0);
        Node copy = dummy;
        while(iter!=null){
            front= iter.next.next;
            copy.next = iter.next;
            iter.next = front;
            copy = copy.next;
            iter = iter.next;
        }
        
        return dummy.next;
    }
}
