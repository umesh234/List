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
	
	public LinkList( int ... nums) {
		this();
		for( int i=0;i< nums.length;i++) {
			append(nums[i]);
		}
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(" {");
		ListNode cur = head ;
		while( cur != null) {
			str.append (cur.data);
			str.append (",");
			cur = cur.next;
		}
		str.deleteCharAt(str.length()-1);
		str.append("}");
		return str.toString();
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

	public boolean prepend( int data ) {
		head = new ListNode( data , head);
		return true;
	}
	
	//returns true if the list has a cycle inside it
	public boolean isCircular( ) {
		ListNode slow = head ;
		ListNode fast = head ; 
		
		while ( slow != null && fast != null && slow!= fast) {
			slow = slow.next;
			
			//increment fast twice
			fast = fast.next ;
			if( fast != null)
				fast = fast.next;
		
		}// end of while loop
		
		if ( fast == null || slow == null) 
			return false;
		return true;
		
	}
	
	//returns m th last node from end ( m =0 is last of list )
	public ListNode fromLast( int index) {
		
		//check input for correctness 
		//really throw exception here
		if( index < 0 || head == null) return null;
		
		// skip first index+1 elements
		ListNode back = head;
		ListNode frontRunner = head;
		while( frontRunner != null && index > -1 ) {
			index--;
			frontRunner = frontRunner.next;
		}
		
		//if we ran out of elements than return -1 
		if( index > -1) 
			return null ;
		
		while ( frontRunner != null) {
			frontRunner = frontRunner.next;
			back = back.next;
		}
		return back;
		
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
