package code.ngill.linkedlists;

import java.util.HashMap;
import java.util.Map;

public class CycleBeginning {

	public static void main(String[] args) {
		Node<Character> head = new Node<Character>('A');
		Node<Character> nodeB = new Node<Character>('B');
		Node<Character> nodeC = new Node<Character>('C');
		Node<Character> nodeD = new Node<Character>('D');
		Node<Character> nodeE = new Node<Character>('E');

		head.setNext(nodeB);
		nodeB.setNext(nodeC);
		nodeC.setNext(nodeD);
		nodeD.setNext(nodeE);
		nodeE.setNext(nodeC);

		System.out.println(CycleBeginning.<Character> findCycleBeginningWBuffer(head).getData());
		System.out.println(CycleBeginning.<Character> findCycleBeginningBook(head).getData());
	}

	/*
	 * With a buffer containing nodes and values they store as a Map. O(n) time
	 * and memory complexity
	 */

	private static <T> Node<T> findCycleBeginningWBuffer(Node<T> node) {
		if (node == null) {
			// throw exception?
		}

		Map<T, Node<T>> nodes = new HashMap<T, Node<T>>();

		while (node != null) {
			if (nodes.containsKey(node.getData())) {
				return nodes.get(node.getData());
			}
			nodes.put(node.getData(), node);
			node = node.getNext();
		}

		// throw exception?
		return null;
	}
	
	/*
	 * From the book. Constant memory complexity and linear time
	 */
	private static <T> Node<T> findCycleBeginningBook(Node<T> node){
		Node<T> slow = node;
		Node<T> fast = node;
		
		while(fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast) {
				break;
			}
		}
		
		if(fast == null || fast.getNext() == null) {
			return null;
		}
		
		slow = node;
		while(fast != slow) {
			fast = fast.getNext();
			slow = slow.getNext();
		}
		
		return slow;
	}
}
