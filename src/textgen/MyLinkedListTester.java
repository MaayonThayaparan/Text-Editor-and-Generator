/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Maayon Thayaparan
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	*/
	@Test
	
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
	}
	
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		try {
			emptyList.add(null);
			fail("Check out null value");
		}
		catch (NullPointerException e) {
		}

		

		
		emptyList.add(1);
		int a = emptyList.get(0);
		assertEquals("Add: check a is correct ", 1, a);
		
		
		longerList.add(10);
		for(int i = 0; i<11; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		int b = longerList.get(10);
		assertEquals("Check b is", 10, b);
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		int a = longerList.size();
		assertEquals("long list size", 10, a);
		
		longerList.add(1); 
		int b = new Integer(longerList.size());
		assertEquals("long list size", 11, b);
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{	
		MyLinkedList<Integer> list2 = new MyLinkedList<Integer>();
		list2.add(65);
		list2.add(21);
		list2.add(42);

		try {
			emptyList.add(0,null);
			fail("Check out null value");
		}
		catch (NullPointerException e) {
		}
		
		try {
			emptyList.add(100,100);
			fail("Check out of bounds index");
		}
		catch (IndexOutOfBoundsException e) {	
		}

		list2.add(0,77);
		int a = list2.get(0);
		assertEquals("Add: check a is correct ", 77, a);
		
		list2.add(4,82);
		int b = list2.get(4);
		assertEquals("Add: check a is correct ", 82, b);

	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		MyLinkedList<Integer> list3 = new MyLinkedList<Integer>();
		list3.add(65);
		list3.add(21);
		list3.add(42);
		
		int a = list3.set(0,11);
		assertEquals("Set: check a is correct ", 11, a);
		int b = list3.get(0); 
		assertEquals("Set: check a is correct ", 11, b);

		
		try {
			list3.set(4, 44);
			fail("Check out of bounds index");
		}
		catch (IndexOutOfBoundsException e) {	
		}
		
		try {
			list3.set(-1, 44);
			fail("Check out of bounds index");
		}
		catch (IndexOutOfBoundsException e) {	
		}
		try {
			list3.set(2, null);
			fail("Check out of bounds index");
		}
		catch (NullPointerException e) {	
		}
		
	}
	

	
}
