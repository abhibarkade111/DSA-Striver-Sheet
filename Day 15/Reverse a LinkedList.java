// Reverse a linkedList 
// 1->2->3->4->5  =>  5->4->3->2->1
// Approach 1:
// Time Complexity - O(N)
// Space Complexity - O(1)

// Code

public Node reverseLinkedList(Node head){
    Node newHead = null;
    while(head!=null){
        Node next  = head.next;
        head.next = newHead
        newHead = head;
        head  = next; 
    }
    return newHead;
}

