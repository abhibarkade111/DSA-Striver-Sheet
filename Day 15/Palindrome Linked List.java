// Palindrome Linked List
// Approach 1:
// steps : 1) Uisng slow and fast pointer find the middle of the linkedlist
//         2) Now reverse the LinkedList from slow.next 
//         3) Move the head and the and slow and check whether both are equals or not if not equal then return false
//         4) if slow cross the end then return true

// Time Complexity :- O(n/2) + O(n/2) + O(n/2)
// Space Complexity :- O(1)

// Code :

/****************************************************************

    Following is the class structure of the LinkedListNode class:
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {

	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		// Write your code here!
        if(head==null || head.next==null) return true;
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = reverseList(slow.next);
        
        slow = slow.next;
        while(slow!=null){
            
            if(!slow.data.equals(head.data)){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
	}
    public static LinkedListNode<Integer> reverseList(LinkedListNode<Integer> head){
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> next = null;
        while(head!=null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}