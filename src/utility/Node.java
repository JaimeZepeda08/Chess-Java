package utility;

/**
 * This class defines a node that stores a value
 * 
 * @author jaime
 *
 * @param <T> The type of the value that this node stores
 */
public class Node<T> {

	T data;
	Node<T> next;

	/**
	 * Constructor for a node object
	 *
	 * @param data the value that is stored in this node
	 * @param next the node that this one point to
	 * @throws IllegalArgumentException if data is null
	 */
	public Node(T data, Node<T> next) throws IllegalArgumentException {
		if (data == null) {
			throw new IllegalArgumentException("data cannot be null");
		}

		this.data = data;
		this.next = next;
	}

	/**
	 * Getter method for the data that this node stores
	 * 
	 * @return the value stored in this node
	 */
	public T getData() {
		return data;
	}

	/**
	 * Getter method for the next node that this one points to
	 * 
	 * @return the next node
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * Setter method for the next node
	 * 
	 * @param next the node that this one is going to point to
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

}
