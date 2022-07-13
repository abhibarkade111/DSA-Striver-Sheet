// Delete Node in a Linked List
// 1->2->3->4  delete 3 => 1->2->4

// Approach 1:
// As we know that head is not given only which node is need to delete is given so we not able to traverse back only able to traverse next
// So simple appraoch copy the next node value to the that node and assign the node.next  = node,next.next

// Time Complexity - O(1)
// Space Complexity - O(1)

// Code :-

/****************************************************************

    Following is the class structure of the LinkedListNode class:

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
        LinkedListNode(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

*****************************************************************/

public class Solution {
	public static void deleteNode(LinkedListNode<Integer> node) {
		// Write your code here.
        if(node.next==null){
            node = null;
        }
        else{
            node.data = node.next.data;
            node.next = node.next.next;
        }
        
	}
}