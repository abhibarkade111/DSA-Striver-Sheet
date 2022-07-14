// Rotate a Linked List
// Right Rotate 
// 1->2->3->4->5 and k=2 => 4->5->1->2->3

// Approach 1: Rotate k time list i.e every time add last to the first
// Time Complexity - O(K*N)
// Space Complexity - O(1)

// Approach 2: Optimal Apparoach

// Steps : 1) Calculate length of the list
//         2) Last node connect to the head i.e make a circular list
//         3) Now find k i. k=len-(k%len)
//         4) Move curr points to head to the k steps
//         5) Now update head as curr.next and make curr.next = null
//         6) Return head

// Time Complexity - O(N) + O(N-(N%K)) i.e O(N)
// Space Complexity - O(1)

// Code :-

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        ListNode curr = head;
        int len = 1;
        while(curr.next!=null){
            len++;
            curr = curr.next;
        }
        
        curr.next=head;
        k= len - (k%len);
        while(k--> 0){
            curr = curr.next;
        }
        
        head = curr.next;
        curr.next = null;
        return head;
    }
}