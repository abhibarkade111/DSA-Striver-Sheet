// Add Two Numbers As Linked Lists
// E.g 2->4->3
//   + 5->6->4
//   ----------
//     7->0->8
// Tip:- Alraedy Numbers are stored in reverse order so no need to reverse the linkedlist

// Approach : Optimal Approach (Only one Approach)
// steps 1) create a new Node dummy and create newNode temp  assign temp to the dummy
//       2) intialize carry to the 0
//       3) until head1!=null || head2!=null || carry==1 
//             initialize sum=0
//             if l1!=null then add l1.data to the sum and l1=l1.next
//             if l2!=null then add l2.data to the sum and l2=l2.next
//             add carry to the sum
//             carry = sum/10
//             create newNode of sum%10
//             assign temp.next = newNode
//             temp = temp.next
//      4) Return dummy.next

Time Complexity :- O(Math.max(Length(l1),Length(l2)))
Space Complexity :- O(Math.max(Length(l1),Length(l2))+1)

// Code:

/****************************************************************

    Following is the class structure of the Node class:

    class LinkedListNode {
        int data;
        LinkedListNode next;
        
        public LinkedListNode(int data) {
            this.data = data;
        }
    }

*****************************************************************/


public class Solution {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        // Write your code here.
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode temp = dummy;
        int carry = 0;
        while(head1!=null || head2!=null || carry==1){
            int sum = 0;
            if(head1!=null){
                sum+=head1.data;
                head1=  head1.next;
            }
            if(head2!=null){
                sum+=head2.data;
                head2 = head2.next;
            }
            sum+=carry;
            carry = sum/10;
            LinkedListNode newNode =  new LinkedListNode(sum%10);
            temp.next = newNode;
            temp = temp.next;
        }
        return dummy.next;
    }
}
