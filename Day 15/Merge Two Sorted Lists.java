// Merge Two Sorted Lists
// 1->2->4 and 1->3->4  =>  1->1->2->3->4->4

// Approach 1: Using Extra Space 
// Create one dummy Node i. newNode 
// newNode.next = list1.val<list2.val? list1 : list2;
// Add reamining Node

// Time Complexity- O(m+n)
// Space Complexity- O(m+n)

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                node.next = list1;
                list1=list1.next;
            }
            else{
                node.next=list2;
                list2=list2.next;
            }
            node = node.next;
        }
        while(list1!=null){
            node.next = list1;
            list1=list1.next;
            node=node.next;
        }
        while(list2!=null){
            node.next=list2;
            list2=list2.next;
            node=node.next;
        }
        return head.next;
    }
}

// Appraoch 2: Without using extra space 
// step 1: Assign l1 and l2 to the two head of the linked lists assign l1 to the smaller head and l2 to the other node and assign the newHead = l1
// step 2: traverse until the temp = l1 , l1.val < l2.val
//         assign temp.next = l2;
//         swap the Node l1 && l2
//         do the same until end
// Return the newHead

// Time Complexity - O(m+n)
// Space Complexity - O(1)

// Code

/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		// Write your code here.
        LinkedListNode<Integer> l1 = first;
        LinkedListNode<Integer> l2 = second;
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.data>l2.data){
            LinkedListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        LinkedListNode res = l1;
        while(l1!=null && l2!=null){
            LinkedListNode tmp  = null;
            while(l1!=null && l1.data<=l2.data){
                tmp = l1;
                l1=l1.next;
            }
            tmp.next = l2;
            LinkedListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        return res;
	}
}
