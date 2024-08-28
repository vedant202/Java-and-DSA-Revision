package LeetCode;

import java.util.Scanner;
import java.util.Stack;

public class Reverse_Nodes_in_Even_Length_Groups {
	
	public static ListNode reverseEvenLengthGroups(ListNode head) {
		int gn = 0;
		ListNode curr = head;
		ListNode lastPrevEle = null;
		ListNode lastOfEvenGroup = null;
		int elementsInPreviousGroup = 0;
		while(curr!=null) {
			gn++;
			if(gn%2==0) {
				elementsInPreviousGroup = reverse(lastPrevEle,curr,gn);
				lastOfEvenGroup = curr;
				curr = curr.next;
			}else {
				int k = gn;
				elementsInPreviousGroup = 0;
				while(curr!=null && k>0) {
					
					lastPrevEle = curr;
					curr = curr.next;
					k--;elementsInPreviousGroup++;
				}
			}
			
		}

        if(gn%2==1 && elementsInPreviousGroup%2==0) {
			reverse(lastOfEvenGroup, lastOfEvenGroup.next,elementsInPreviousGroup);
		}
		else if (gn%2==0 && elementsInPreviousGroup%2==1) {
			reverse(lastPrevEle, lastPrevEle.next, elementsInPreviousGroup);
		}
		return head;
		
    }
	
	public static int reverse(ListNode last,ListNode head,int gn) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = curr.next;
		int count=0;
		
		while(curr!=null && gn>0) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			gn--;
			count++;
			

			
		}
		
		head.next = next;
		last.next = prev;
		return count;
	}
	
	public static ListNode reverse2(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		
		while(curr!=null && curr.next!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
			
			System.out.println(curr.val);

			
		}
		curr.next = prev;
		head = curr;
		return head;
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
		
		
		ListNode curr=reverseEvenLengthGroups(head);
		
//		5,6,2,3,9,1,4,8,3,7
//		ListNode curr = head;
		System.out.println("reversing");
		while(curr!=null) {
			System.out.println(curr.val);
			curr = curr.next;
			
		}
	}
}
