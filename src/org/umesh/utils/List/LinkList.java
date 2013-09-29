package org.umesh.utils.List;

public class LinkList {

	public static class ListNode {
		@Override
		public String toString() {
			return "ListNode [next=" + next + ", data=" + data + "]";
		}
		public ListNode(int data, ListNode next ) {
			super();
			this.next = next;
			this.data = data;
		}
		
		private ListNode next ;
		private int data ;
		
	}
	
	ListNode head ;
	
	public LinkList() {
		head = null ;
	}
	
	public boolean append(int data) {
		if ( head == null) {
			head = new ListNode(data , null);
			return true ;
		}
		ListNode cur = head ;
		while ( cur.next != null ) 
			cur = cur.next ;
		cur.next = new ListNode(data , null);
		return true;
	}
	
	public int size() {
		int count = 0;
		ListNode cur = head;
		while ( cur != null) {
			count++;
			cur = cur.next;
		}
		return count;
	}
}
