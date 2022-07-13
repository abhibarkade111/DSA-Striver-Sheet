// Intersection of Two Linked Lists
// 1->2->3->4->5->6->7->8
// 2->3->4->-^
// Output is 4

// Approach 1: Brute Force 
// Pick the one node from the one linked and compare with each node from the second linked list 
// If equal then return the Node

// Time Complexity: O(M*N)
// Space Complexity: O(1)

// Approach 2: Using HashSet 
// Add each node of any one of the list to the HashSet 
// Now Traverse the Second list and check whether the Node is present in the HasSet if present then return the Node

// Time Complexity- O(M+N)
// Space Complexity- O(M)

// Code:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hs = new HashSet<>();
        while(headA!=null){
            hs.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(hs.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }
}


// Approach 3: Optimal Appraoch 1
// Steps 1: Calculate the Length of both the Linked List
//       2: Find the Difference Between them
//       3: Now move the pointer of largest linked list upto the difference
//       4: Now move the Both the pointers and check they are equal if equal then return the node

// Time Complexity - O(2M)
// Space Complexity- O(1)


// Approach 4: Optimal Approach 2
// Steps 1: Assign two pointer to the heads of the LinkedList
//       2: Now travesre the both 
//       3: If any one of them cross the end i.e null then assign it to the other list head same in case of other pointer
//       4: If Both are equal then return the Node

// Time Complexity - O(2M)
// Space Complexity - O(1)

// Code:

/************************************
	 
	 //Following is the class structure of the LinkedListNode class:
	 
	  class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;
		
		public LinkedListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}

*****************************************/
public class Solution {

	public static int findIntersection(LinkedListNode<Integer> firstHead, LinkedListNode<Integer> secondHead) {
		if(firstHead == null || secondHead==null) return -1;
        LinkedListNode<Integer> a = firstHead;
        LinkedListNode<Integer> b = secondHead;
        while(a!=b){
            a= a==null?secondHead:a.next;
            b= b==null?firstHead:b.next;
        }
        return a==null?-1:a.data;
	}
}