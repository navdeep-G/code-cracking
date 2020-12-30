package code.ngill.linkedlists;

public class PartitionList {

	public static void main(String[] args) {
		Node<Integer> node = new Node<Integer>(1);
		node.appendToTail(3).appendToTail(7).appendToTail(5).appendToTail(2)
				.appendToTail(9).appendToTail(4);
		node.printList();
		partitionList(node, 5).printList();
		partitionList2(node, 5).printList();
	}

	private static Node<Integer> partitionList2(Node<Integer> node, int x) {
		Node<Integer> before = null;
		Node<Integer> after = null;
		
		while (node != null) {
			Node<Integer> next = node.getNext();
			
			if(node.getData() < x) {
				node.setNext(before);
				before = node;
			} else {
				node.setNext(after);
				after = node;
			} 
			node = next;
		}

		if(before == null) {
			return after;
		}
		
		Node<Integer> head = before;
		while(before.getNext() != null) {
			before = before.getNext();
		}

		before.setNext(after);
		
		return head;
	}
	
	private static Node<Integer> partitionList(Node<Integer> node, int x) {
		Node<Integer> beforeStart = null;
		Node<Integer> beforeEnd = null;
		
		Node<Integer> afterStart = null;
		Node<Integer> afterEnd = null;
		
		while (node != null) {
			Node<Integer> next = node.getNext();
			node.setNext(null);
			if(node.getData() < x) {
				if(beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.setNext(node);
					beforeEnd = node;
				}
			} else {
				if(afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.setNext(node);
					afterEnd = node;
				}
			} 

			node = next;
		}
		
		if(beforeStart == null) {
			return afterStart;
		}
		
		beforeEnd.setNext(afterStart);
		
		return beforeStart;
	}

}
