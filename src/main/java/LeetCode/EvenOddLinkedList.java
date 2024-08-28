package LeetCode;

import java.util.Scanner;

public class EvenOddLinkedList {
	
	public static ListNode oddEvenList(ListNode head) {
	     ListNode  even = null;
	     ListNode odd = null;
	     ListNode curr = head;
	     ListNode t1 = null;
	     ListNode t2 = null;
	     int i=1;
	     if(head==null){
	            return head;
	         }
	     while(curr!=null) {
	    	 
	    	 if(i%2==0) {
	    		 
	    		 if(even==null) {
	    			 even = new ListNode(curr.val);
			    	 t1 = even;
	    		 }else {
	    			 t1.next = new ListNode(curr.val);
		    		 t1 = t1.next;
	    		 }
	    		 
	    		 
	    	 }else if(i%2==1) {
	    		 System.out.println("odd curr val :- "+curr.val);
	    		 if(odd==null) {
	    			 odd = new ListNode(curr.val);
			    	 t2 = odd;
	    		 }else {
	    			 t2.next = new ListNode(curr.val);
		    		 t2 = t2.next;
	    		 }
	    		 
	    		 
	    	 }
	    	 
	    	 i++;
	    	 System.out.println("loop curr :- "+curr.val);
	    	 
	    	 curr = curr.next;
	     }
//	     odd.next = null;
	     ListNode newList = odd;
	     ListNode currNewList = newList;
	     while(currNewList!=null && currNewList.next!=null) {
	    	 currNewList = currNewList.next;
	     }
	     currNewList.next=even;
	     
	     return newList;
    }
	
	public static void main(String[] args) {
		ListNode head = null;

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Enter Node value and enter -1 to exit");
			int val = sc.nextInt();

			if (val == -1) {
				break;
			}
			ListNode newNode = new ListNode(val);

			if (head == null) {
				head = newNode;
			} else {
				ListNode temp = head;

				while (temp.next != null) {
					temp = temp.next;

				}
				temp.next = newNode;
			}

		}

		ListNode curr=oddEvenList(head);

//		5,6,2,3,9,1,4,8,3,7
//		ListNode curr = head;
		System.out.println("reversing");
		while (curr != null) {
			System.out.println(curr.val);
			curr = curr.next;

		}
	}

}
