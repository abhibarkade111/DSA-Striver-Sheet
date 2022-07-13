// Detect the Cycle of Linkked List-II
// Approach 1: Using HashSet 
// Start traversing the LinkedList if the node is present in hashset then return Node else add the node to the HashSet
// if Node cross the end then return null

// Time Complexity - o(N)
// Space Complexity- O(N)

// Approach 2: Optimal Approach 
// Algorithm Divide in two Steps 1) Find the Collision point by using slow and fast pointer 
//                               2) Now assign the entry pointer to the head and move entry and slow by one step and check whether entry and slow are equal then return the Entry

// Time Complexity - O(N)
// Space Complexity - O(1)

// Code:-

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                while(slow!=entry){
                    slow=slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }
}