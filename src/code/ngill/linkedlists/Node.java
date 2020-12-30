package code.ngill.linkedlists;

public class Node<T> {

	private Node<T> next;
	private T data;
	
	public Node(T data) {
		this.data = data;
	}

	public Node<T> appendToTail(T data) {
		Node<T> tail = new Node<T>(data);
		Node<T> node = this;
		while(node.getNext() != null) {
			node = node.getNext();
		}
		node.next = tail;
		return tail;
	}
	
	public void printList() {
		Node<T> node = this;
		while (node != null) {
			System.out.print(node.getData() + " ");
			node = node.getNext();
		}
		System.out.println();
	}
	
	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
}
