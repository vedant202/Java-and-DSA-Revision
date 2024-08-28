package LeetCode;

// LeetCode 1721 : Swapping Nodes in a Linked List

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 

public class Swapping_Nodes {
	
	public static ListNode swapNodes(ListNode head, int k) {
		ListNode curr = head;
		for(int i=1;i<k;i++) {
			curr =curr.next;
		}
		ListNode a = curr;
		ListNode b= head;
		
		while(curr!=null && curr.next!=null) {
			curr = curr.next;
			b = b.next;
		}
		
		int temp = a.val;
		a.val = b.val;
		b.val = temp;
		
        return head;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		head.next =node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		ListNode curr = head;
		
		while(curr.next!=null && curr!=null) {
			System.out.println(curr.val);
			curr = curr.next;
		}
		
		ListNode head2 = swapNodes(head,2);
		curr = head2;
		System.out.println("After Swapped");
		
		while(curr.next!=null && curr!=null) {
			System.out.println(curr.val);
			curr = curr.next;
		}
		
	}
}
