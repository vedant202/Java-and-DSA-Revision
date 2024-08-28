package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import LeetCode.ListNode;


// 1290. Convert Binary Number in a Linked List to Integer

public class LinkedList_DecimalToInteger {
	public static int getDecimalValue(ListNode head) {
		Queue<Integer> queue = new LinkedList<Integer>();
		ListNode curr = head;
		int sum=0;
		int length=0;
		while(curr!=null && curr.next!=null) {
			curr = curr.next;
			length++;
		}
		curr = head;
		int i = length;
		while(curr!=null) {
			sum += (int) ( Math.pow(2, i) * curr.val);
			curr = curr.next;
			i--;
		}
		
		
	    return sum;
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
//		ListNode node2 = new ListNode(0);
//		ListNode node3 = new ListNode(1);
//		ListNode node4 = new ListNode(1);
		
//		head.next =node2;
//		node2.next = node3;
//		node3.next = node4;
		
		int sum = getDecimalValue(head);
		System.out.println("Sum :- "+sum);
	}
}
