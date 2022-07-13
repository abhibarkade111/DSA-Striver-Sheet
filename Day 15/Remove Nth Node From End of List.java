// Remove Nth Node From End of List
// E.g 1->2->3->4->5  and K=2  => 1->2->3->5

// Approch 1: Brute Force 
// Steps 1) Count the Node 
//       2) Find Number of Node from front i.e num = count-k
//       3) traverse upto num and maintain the prev of it at every step 
//       4) assign prev.next  = prev.next.next
//       5) return the head
// Check only two edge case i.e if deleted node is head then return head.next and if deleted node is last node then assign prev.nexr = null

// Time Complexity - O(n)+O(n)
// Space Complexity - O(1)

// Code 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        if(head.next==null){
            return null;
        }
        int c=0;
        while(temp!=null){
            c++;
            temp = temp.next;
        }
        int k = c-n;
        if(k==0){
            return head.next;
        }
        ListNode prev=head;
        int i=0;
        temp=head;
        while(i!=k && temp.next!=null){
            prev =temp;
            temp=temp.next;
            i++;
        }
        prev.next = temp.next;
        return head;
    }
}

// Approach 2 : Better Approach in O(n)
// Use Slow and fast pointer
// Steps : 1) Create one dummy node which is dummy.next = head;
//         2) if traverse the fast node of K steps
//         3) Now traverse the both the slow and fast pointer by one step until the fast reaches the last node
//         4) If fast reaches the last Node then assign slow.next  = slow.next.next
//         5) return slow.next==head ? slow.next.next : head

// Time Complexity - O(n)
// Space Complexity - O(1)

// Code :-

import java.util.* ;
import java.io.*; 
/****************************************************************
	
	Following is the structure of the Singly Linked List.
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

****************************************************************/

public class Solution {
	public static LinkedListNode<Integer> removeKthNode(LinkedListNode<Integer> head, int K) {
		// Write your code here.
        LinkedListNode<Integer> start = new LinkedListNode<Integer>(-1);
        start.next = head;
        LinkedListNode<Integer> fast = start;
        LinkedListNode<Integer> slow = start;
        if(K==0) return head;
        for(int i=1;i<=K;i++){
            fast = fast.next;
        }
        
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        if(slow.next==head){
            return slow.next.next;
        }
        slow.next = slow.next.next;
        return head;
	}
}

