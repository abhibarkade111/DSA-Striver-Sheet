// Reverse Nodes in k-Group
// Leetcode Hard Problem

// Input:  1->2->3->4->5->6->7->8 and k=3
// output: 3->2->1->6->5->4->7->8

// Approach : 1) Create a new dummyNode Node 
//            2) Assign curr, prev,next to the dummy
//            3) count the number of nodes 
//            4) reverse the nodes in the groups and count-=k
//            5) do the same count>=k 
//            6) return the dummy.next

// Time Complexity - O(N)
// Space Complexity - O(1)

// Code 1: On Leetcode
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==1){
            return head;
        }
        ListNode curr=head;
        int n=0;
        while(curr!=null){
            n++;
            curr=curr.next;
        }
        curr = head;
        ListNode prev, newHead, next;
        prev=null;
        newHead = null;
        curr=head;
        ListNode t1=null, t2=head;
        while(n>=k){
            for(int i=0;i<k;i++){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            if(newHead==null){
                newHead = prev;
            }
            if(t1!=null){
                t1.next = prev;
            }
            t2.next = curr;
            t1=t2;
            t2=curr;
            prev=null;
            n=n-k;
        }
        return newHead;
    }
}

// Code 2: on CodeStudio
import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/

public class Solution {
	public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
		// Write your code here.
        if(head==null || n==1 && b[0]==1) return head;
        int count=0;
        Node dummy = new Node(0);
        dummy.next = head;
        Node curr=dummy,next=dummy,prev=dummy;
        while(curr.next!=null){
            count++;
            curr=curr.next;
        }
        int j=0;
        while(n!=0){
            if(count<0 || prev.next==null ||  prev.next.next==null) break;
            if(b[j]==0){
                n--;
                j++;
                continue;
            }
            curr = prev.next;
            next = curr.next;
            for(int i=1;i<Math.min(b[j],count);i++){
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count=count-b[j];
            n--;
            j++;
        }
        return dummy.next;
	}
}