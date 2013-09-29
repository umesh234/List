package org.umesh.utils.List;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.umesh.utils.List.LinkList.ListNode;

@RunWith(Parameterized.class)
public class LinkListTest {

	int expectedSize ;
	int[] numbers ;
	public LinkListTest(int c , int a, int b ) {
		this.expectedSize = c;
		this.numbers = new int[2] ;
		this.numbers[0] = a ;
		this.numbers[1] = b ; 
	}
	
	@Parameters
	public static Collection<Object[]> generateData() {
		 Object[][] testCases = {
				 				  { 2,1,1 }
		 						};
		return Arrays.asList(testCases);
	 }
	
	@Test
	public void test() {
		LinkList ll = new LinkList();
		for( int i=0;i<numbers.length;i++){
			ll.append(numbers[i]);
		}
		
		int result = ll.size();
		assertEquals( " TestArgs: " + numbers , expectedSize , result);
	}
	
	@Test 
	public void testLists() {
		LinkList l = new LinkList(3,4,5,6);
		System.out.println(l);
		//testFromLast(l);
		testFromlast1(l);
		
	}
	
	//bad unit testing
	public void testFromlast1(LinkList l ) {
		LinkList l2 = new LinkList(3,4,3,4,5);
		 {
			 ListNode ll = l2.fromLast(3, -1);
			 int k = l2.fromLastIndex(3, -1);
			 System.out.println(" -" + l2.toString(ll) + k );
		 }
		 {
			 ListNode ll = l2.fromLast(3, 0);
			 int k = l2.fromLastIndex(3, 0);
			 System.out.println(" -" + l2.toString(ll) + k );
		 }
		 {
			 ListNode ll = l2.fromLast(3, 1);
			 int k = l2.fromLastIndex(3, 1);
			 System.out.println(" -" + l2.toString(ll) + k );
		 }
		 {
			 ListNode ll = l2.fromLast(3, 2);
			 int k = l2.fromLastIndex(3, 2);
			 System.out.println(" -" + l2.toString(ll) + k );
		 }
		 {
			 ListNode ll = l2.fromLast(3, 3);
			 int k = l2.fromLastIndex(3, 3);
			 System.out.println(" -" + l2.toString(ll) + k );
		 }
	}
	
	public void testFromLast(LinkList l) {
		assertEquals ( "List Length : 4 " , 4 , l.size() );
		for ( int i=-2;i< l.size() +2;i++){
			System.out.println(" list is " + l + " i is " + i + " from last is " + l.fromLast(i) );
		}
	}
	

}
