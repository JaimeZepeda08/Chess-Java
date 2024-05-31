package utility;

import dataStructures.QueueADT;

/**
 * This class defines a singly-linked list that represents a path
 * 
 * @author jaime
 *
 */
public class Path<T> implements QueueADT<T> {

	Node<T> head; // first node in the path
	Node<T> tail; // last node in the path
	int size; // current size of queue

	/**
	 * Constructor for a queue that represents a path object
	 */
	public Path() {
		head = null;
		tail = head;
		size = 0;
	}

	@Override
	public void enqueue(T data) {
		if (isEmpty()) {
			head = new Node<T>(data, null);
			tail = head;
		} else {
			tail.setNext(new Node<T>(data, null));
			tail = tail.getNext();
		}
		size++;
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			return null;
		}

		Node<T> nodeToReturn = head;
		head = head.getNext();
		size--;
		return nodeToReturn.getData();
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			return null;
		}

		return head.getData();
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

}
