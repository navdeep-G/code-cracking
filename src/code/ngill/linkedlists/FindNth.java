package code.ngill.linkedlists;


public class FindNth {

	public static void main(String[] args) {
		Node<Integer> node = new Node<Integer>(1);
		node.appendToTail(3).appendToTail(2).appendToTail(5).appendToTail(7).appendToTail(9).appendToTail(4);
		node.printList();
		System.out.println();
		System.out.println(findNth(node, 4));
		System.out.println(findNthWithRunner(node, 4));
		System.out.println(findNthRecursive(node, 4, new IntWrapper()));
	}

	private static <T> T findNth(Node<T> node, int n) {
		int size = 0;
		
		Node<T> runner = node;
		while(runner != null) {
			size++;
			runner = runner.getNext();
		}
		
		for (int j = 0; j < size - 4; j++) {
			node = node.getNext();
		}
		
		return node.getData();
	}

	private static <T> T findNthWithRunner(Node<T> node, int n) {
		if(n < 1) {
			return null;
		}
			
		Node<T> first = node;
		Node<T> second = node;
		
		for(int j = 0 ; j < n ; j++) {
			if(second != null) {
				second = second.getNext();
			} else {
				return null;
			}
		}
		
		if(second == null) {
			return null;
		}
		
		while(second != null) {
			second = second.getNext();
			first = first.getNext();
		}
		
		return first.getData();
	}
	
	private static <T> T findNthRecursive(Node<T> node, int n, IntWrapper counter) {
		if(n < 1) return null;
		if(node.getNext() == null) {
			counter.counter++;
			return null;
		}
		
		T result = findNthRecursive(node.getNext(), n, counter);
		
		if(result == null) {
			counter.counter++;
			if(counter.counter == n) {
				return node.getData();
			}
		} 
		
		return result;
	}
	
	private static class IntWrapper {
		public int counter = 0;
	}
	
}
