package code.ngill.linkedlists;

public class RecursiveFollowUp {

	public static void main(String[] args) {
		Node<Integer> node1 = new Node<Integer>(9);
		node1.appendToTail(8).appendToTail(7);
		node1.printList();
		Node<Integer> node2 = new Node<Integer>(1);
		node2.appendToTail(4);
		node2.printList();
		
		addNumbers(node1, node2, 0).printList();
	}

	private static Node<Integer> addNumbers(Node<Integer> node1,
			Node<Integer> node2, int i) {
		int listOneSize = getListSize(node1);
		int listTwoSize = getListSize(node2);
		int difference = (listOneSize >= listTwoSize) ? listOneSize - listTwoSize : listTwoSize - listOneSize;
		
		if(difference > 0 && listOneSize > listTwoSize) {
			node2 = appendZerosToFront(node2, difference);
	 	} else if (difference > 0 && listOneSize < listTwoSize) {
	 		node1 = appendZerosToFront(node1, difference);
	 	}
		
		IntWrapper carry = new IntWrapper();
		Node<Integer> summedNodes = addNumbersRecursively(node1, node2, carry);
		
		if(carry.carry > 0) {
			Node<Integer> head = new Node<Integer>(carry.carry);
			head.setNext(summedNodes);
			summedNodes = head;
		}
		
		return summedNodes;
	}

	private static Node<Integer> addNumbersRecursively(Node<Integer> node1,
			Node<Integer> node2, IntWrapper carry) {
		Node<Integer> resultNode;
		if(node1.getNext() == null && node2.getNext() == null) {
			resultNode = new Node<Integer>((node1.getData() + node2.getData() + carry.carry) % 10);
			carry.carry = (node1.getData() + node2.getData() + carry.carry) / 10;
			return resultNode;
		}
		
		Node<Integer> nextNode = addNumbersRecursively(node1.getNext(), node2.getNext(), carry);
		resultNode = new Node<Integer>((node1.getData() + node2.getData() + carry.carry) % 10);
		carry.carry = (node1.getData() + node2.getData() + carry.carry) / 10;
		resultNode.setNext(nextNode);

		return resultNode;
	}

	private static Node<Integer> appendZerosToFront(Node<Integer> node,
			int difference) {
		Node<Integer> newNode = new Node<Integer>(0);
		Node<Integer> head = newNode;
		for(int i = 1; i < difference; i++) {
			Node<Integer> nextNewNode = new Node<Integer>(0);
			newNode.setNext(nextNewNode);
			newNode = nextNewNode;
		}
		newNode.setNext(node);
		return head;
	}

	private static int getListSize(Node<Integer> node) {
		int size = 0;
		while(node != null) {
			size++;
			node = node.getNext();
		}
		return size;
	}

	private static class IntWrapper {
		public int carry = 0;
	}
	
}
