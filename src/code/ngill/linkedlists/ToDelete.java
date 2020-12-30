package code.ngill.linkedlists;

public class ToDelete {

	public static void main(String[] args) {
		Node<Integer> node = new Node<Integer>(1);
		Node<Integer> toDelete = node.appendToTail(3).appendToTail(2);
		toDelete.appendToTail(5).appendToTail(7).appendToTail(9).appendToTail(4);
		node.printList();
		
		System.out.println();
		
		delete(toDelete);
		
		node.printList();
		
	}

	private static void delete(Node<Integer> toDelete) {
		if(toDelete == null || toDelete.getNext() == null) {
			return;
		}
		
		toDelete.setData(toDelete.getNext().getData());
		toDelete.setNext(toDelete.getNext().getNext());
	}
	
}
