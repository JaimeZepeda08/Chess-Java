package dataStructures;

/**
 * Interface that defines a Queue
 * 
 * @author jaime
 *
 * @param <T>
 */
public interface QueueADT<T> {

	/**
	 * This method adds a node at the end of the queue
	 * 
	 * @param value the value to be added
	 */
	public void enqueue(T value);

	/**
	 * This method returns the first item in the queue and removes it
	 * 
	 * @return the first item in the queue
	 */
	public T dequeue();

	/**
	 * This method returns the first item in the queue without removing it
	 * 
	 * @return the first item in the queue
	 */
	public T peek();

	/**
	 * Checks if the queue is empty
	 * 
	 * @return true if no items are left in the queue, false otherwise
	 */
	public boolean isEmpty();

}
