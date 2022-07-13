// Flattening a Linked List 
// As Node having bottom and the next pointer 
// So Using merge sort we can combine the LinkedList as Links are already sorted

// Approach 
// Recursively call the same function until end and from last list start merging with the previous do the same process until all the Lists are merged
// Time Complexity :- O(Sum of all Nodes)
// Space Complexity :- O(1)

// Code 

/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node mergeTwoLists(Node a,Node b){
        Node temp = new Node(0);
        Node res = temp;
        
        while(a!=null && b!=null){
            if(a.data<b.data){
                temp.bottom  = a;
                temp = temp.bottom;
                a = a.bottom;
            }
            else{
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }
        if(a!=null) temp.bottom = a;
        else temp.bottom= b;
        return res.bottom;
    }
    
    Node flatten(Node root)
    {
	    // Your code here
	    if(root==null || root.next==null) return root;
	    root.next = flatten(root.next);
	    root = mergeTwoLists(root,root.next);
	    return root;
    }
}