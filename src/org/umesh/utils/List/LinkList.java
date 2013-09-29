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

	public String toString(ListNode l) {
		StringBuilder str = new StringBuilder();
		str.append(" { ");
		ListNode cur = l ;
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
	
	// ListNode containing index last occurrence of data 
	public ListNode fromLast( int data, int index) {
		
		//check parameter sanity 
		if( index < 0 ) return null ;
		if( index ==0 ) return lastIndexOf(data);
		
		ListNode front = head;
		while( index > 0 && front != null) {
			if( front.data == data) {
				index--;
			}
			front = front.next;
		}// front points one node ahead to index_th occurrence of data 
		
		if( index > 0) 
			return null;
		
		ListNode back = null;
		while ( front != null) {
			if ( front.data == data) {
				//increment back till next data is found
				do { 
					if( back == null)
						back = head;
					else
						back = back.next;
				}while( back.data != data) ;
					
			}
			front = front.next;
		}
		
		return back;
	}
	
	// index of containing index last occurrence of data 
		public int fromLastIndex( int data, int index) {
			
			//check parameter sanity 
			if( index < 0 ) return -1 ;
			if( index ==0 ) return indexOf(data);
			int c = -1;
			ListNode front = head;
			while( index > 0 && front != null) {
				if( front.data == data) {
					index--;
				}
				front = front.next;
			}// front points one node ahead to index_th occurrence of data 
			
			if( index > 0) 
				return -1 ;
			
			ListNode back = null;
			while ( front != null) {
				if ( front.data == data) {
					//increment back till next data is found
					do { 
						if( back == null) {
							back = head;
							c = 0;
						}
						else
							back = back.next;
						c++;
					}while( back.data != data) ;
						
				}
				front = front.next;
			}
			
			return c;
		}
		
	
	//first list node index of data 
	public ListNode firstIndexOf( int data) {
		ListNode cur = head ;
		while ( cur != null) {
			if(cur.data == data) {
				return cur;
			}
			cur = cur.next;
		}
		return null;
	}
	
	//last listnode reference in list containing data
	public ListNode lastIndexOf(int data) {
		ListNode cur = head;
		ListNode prev = null;
		while ( cur != null) {
			if( cur.data == data) {
				prev = cur;
			}
			cur = cur.next;
		}
		return prev;
	}
	
	//first position of data in list 
	public int indexOf(int data) {
		int index = -1;
		ListNode cur = head;
		while( cur != null) {
			index++;
			if( cur.data == data)
				return index;
			cur = cur.next;
		}
		return -1;
	}
		
	public void clear() {
		head = null;
		
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
