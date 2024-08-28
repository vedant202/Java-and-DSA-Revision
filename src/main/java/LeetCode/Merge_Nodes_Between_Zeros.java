package LeetCode;

import java.util.Scanner;



public class Merge_Nodes_Between_Zeros {
	
	public static ListNode mergeNodes(ListNode head) {
		
		int sum = 0;
		ListNode newList =  null;
		ListNode curr = head;
		ListNode temp = newList;
		while(curr!=null && curr.next!=null) {
			System.out.println("curr val :- "+curr.val);
			curr = curr.next;
			
			if(curr.val==0) {
				ListNode newNode = new ListNode(sum);
				if(newList==null) {
					newList=newNode;
					temp=newList;
				}else {
					
//					while(temp.next!=null) {
//						temp = temp.next;
//					}
					
					temp.next = newNode;
					temp = temp.next;
				}
				sum=0;
			}else {
				sum +=curr.val;
			}
			
		}
		return newList;
	}
	
	public static void main(String[] args) {
		
		ListNode head = null;
		
		Scanner sc = new Scanner(System.in);
		
		
		
		while(true) {
			System.out.println("Enter Node value and enter -1 to exit");
			int val = sc.nextInt();
			
			if(val==-1) {
				break;
			}
			ListNode newNode = new ListNode(val);
			
			
			if(head==null) {
				head=newNode;
			}else {
				ListNode temp = head;
				
				while(temp.next!=null) {
					temp = temp.next;
					
				}
				temp.next = newNode;
			}
			
		}
		
		
		ListNode curr=mergeNodes(head);
		
		
//		ListNode curr = head;
		
		while(curr!=null) {
			System.out.println(curr.val);
			curr = curr.next;
			
		}
		
	}
}
