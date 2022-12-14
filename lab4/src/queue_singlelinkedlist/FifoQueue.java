package queue_singlelinkedlist;

import java.util.*;

import org.junit.jupiter.params.provider.NullSource;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**
	 * Inserts the specified element into this queue, if possible
	 * post: The specified element is added to the rear of this queue
	 * 
	 * @param e the element to insert
	 * @return true if it was possible to add the element
	 *         to this queue, else false
	 */
	public boolean offer(E e) {
		boolean state = false;
		if (last == null) {
			last = new QueueNode<E>(e);
			last.next = last;
			state = true;

		} else {
			QueueNode<E> save = last;
			last = new QueueNode<E>(e);
			last.next = save.next;
			save.next = last;

		}
		size++;
		return state;
	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue,
	 * returning null if this queue is empty
	 * 
	 * @return the head element of this queue, or null
	 *         if this queue is empty
	 */
	public E peek() {
		if (last == null) {
			return null;
		} else {
			return last.next.element;
		}

	}

	/**
	 * Retrieves and removes the head of this queue,
	 * or null if this queue is empty.
	 * post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {

		if (last == null) {
			return null;
		}
		if (size == 1) {
			E element = last.element;
			last = null;
			size--;
			return element;

		}
		E element = last.next.element;
		last.next = last.next.next;
		size--;
		return element;
	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */

	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	/**
	 * Appends the specified queue to this queue
	 * post: all elements from the specified queue are appended
	 * to this queue. The specified queue (q) is empty after the call.
	 * 
	 * @param q the queue to append
	 * @throws IllegalArgumentException if this queue and q are identical
	 */
	public void append(FifoQueue<E> q){
		if(this==q || (this.last==null && q.last==null)){
			throw new IllegalArgumentException();
		} else if (this.last==null){
			this.last=q.last;
			this.size=q.size(); // q.size or q.size() ?? fr??ga
		} else if (q.last!=null){
			this.size = this.size + q.size();

			QueueNode<E> save = new QueueNode<E>(q.last.element);
			save.next = q.last.next;
			QueueNode<E> save2 = new QueueNode<E>(save.next.element);
			save2.next = save.next.next;

			save.next = this.last.next;
			this.last.next = save2;
			this.last = save;

		}
		q.size=0;
		q.last=null;

	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;

		private QueueIterator() {
			pos = last;
		}

		@Override
		public boolean hasNext() {
			if (pos == null) {
				return false;
			}
			return true;
		}

		@Override
		public E next() {
			if (pos == null) {
				throw new NoSuchElementException();
			}
			if (pos.next.equals(last)) { // vid slute, retunera sista elementet och s??tt resten till null
				E element = pos.next.element;
				pos = null;
				return element;
			}
			pos = pos.next; // G??r igenom noderna
			return pos.element;
		}
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}
