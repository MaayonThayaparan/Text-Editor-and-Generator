package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author Maayon Thayaparan
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {		
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null); 

		this.head.next = tail;
		this.tail.prev = head; 

	}
	

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if (element == null) {

			throw new NullPointerException();
		}
		else {
			LLNode<E> newVal = new LLNode<E>(element, this.tail.prev, this.tail);
			this.tail.prev.next = newVal; 
			tail.prev = newVal; 
		}
		size += 1; 
		
		
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		LLNode<E> currNode = this.getCurrNode(index);
		
		if (currNode == tail) {
			throw new IndexOutOfBoundsException();
		}
		
		return currNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		
		if (element == null) {

			throw new NullPointerException();
		}
		
		LLNode<E> currNode = this.getCurrNode(index);
		
		LLNode<E> newNode = new LLNode<E>(element, currNode.prev, currNode);
		currNode.prev.next = newNode;
		currNode.prev = newNode; 
		size +=1; 
		
		
	}


	/** Return the size of the list */
	public int size() 
	{
		return size; 
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		LLNode<E> currNode = this.getCurrNode(index);
		
		currNode.prev.next = currNode.next;
		currNode.next.prev = currNode.prev; 
		currNode.next = null;
		currNode.prev = null;
		size -= 1; 
		
		return currNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (element == null) {

			throw new NullPointerException();
		}
		
		LLNode<E> currNode = this.getCurrNode(index);
		
		if (currNode == tail) {
			throw new IndexOutOfBoundsException();
		}
		
		currNode.data = element; 
		
		return currNode.data;
	}  
	
	public LLNode<E> getCurrNode(int index){
		
		LLNode<E> currNode = head.next;
		
		if (index < 0) {
			throw new IndexOutOfBoundsException(); 
		}
		
		for (int i = 0; i < index; i++) {
			
			if (currNode == tail) {
				throw new IndexOutOfBoundsException();
			}
			
			currNode = currNode.next; 
		}
		return currNode; 
	}
	
	public String toString() {
		StringBuilder output = new StringBuilder(); 
		
		if (this.size() <= 0) {
			return "Empty list"; 
		}
		
		else {
			for (int i=0; i<size() ; i++) {
				output.append(i + " " + this.get(i) + "\n");
			}
		}

		return output.toString(); 
	}
	
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> prev) 
	{
		this(e);
		this.prev = prev;
	}
	
	public LLNode(E e, LLNode<E> prev, LLNode<E> next)
	{
		this(e, prev);
		this.next = next;
	}

}
