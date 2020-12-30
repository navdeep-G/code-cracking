package code.ngill.linkedlists;


public class Recursive {

	public static void main(String[] args) {
		Node<Integer> node1 = new Node<Integer>(7);
		node1.appendToTail(1).appendToTail(6);
		node1.printList();
		Node<Integer> node2 = new Node<Integer>(5);
		node2.appendToTail(9);
		node2.printList();
		addTwoNumbers(node1, node2).printList();
		addNumbersRecursive(node1, node2, 0).printList();
	}
	
	/*********************************************************
	 * Recursive solution. Shorter but more memory consuming.*
	 *********************************************************/
	
	private static Node<Integer> addNumbersRecursive(
			Node<Integer> one, Node<Integer> two, int carry) {
		if (one == null && two == null && carry == 0) {
			return null;
		}

		int sum = carry;
		if (one != null) {
			sum += one.getData();
		}

		if (two != null) {
			sum += two.getData();
		}

		Node<Integer> node = new Node<Integer>(sum % 10);

		if (one != null || two != null || sum > 9) {
			node.setNext(addNumbersRecursive(
					one != null ? one.getNext() : null,
					two != null ? two.getNext() : null, sum > 9 ? 1 : 0));
		}

		return node;
	}

	/*********************************************************
	 * Iterative. Much longer but less memory consuming.     *
	 *********************************************************/
	
	private static Node<Integer> addTwoNumbers(
			Node<Integer> one, Node<Integer> two) {
		Node<Integer> head = new Node<Integer>(0);
		Node<Integer> result = head;

		while (one != null || two != null) {
			int sum = addValues(one, two);
			Node<Integer> nextResult;
			if (sum < 10) {
				boolean isLast = isLast(one, two);
				nextResult = nextResult(result, sum, 0, isLast);
			} else {
				nextResult = nextResult(result, sum % 10, 1, false);
			}
			result.setNext(nextResult);
			result = nextResult;

			one = getNext(one);
			two = getNext(two);
		}

		return head;
	}

	private static boolean isLast(Node<Integer> one,
			Node<Integer> two) {
		if ((one != null && one.getNext() != null)
				|| (two != null && two.getNext() != null)) {
			return false;
		}
		return true;
	}

	private static Node<Integer> nextResult(
			Node<Integer> result, int sum, int i, boolean isLast) {
		result.setData(result.getData() + sum);

		if (isLast) {
			return null;
		}

		return new Node<Integer>(i);
	}

	private static Node<Integer> getNext(Node<Integer> node) {
		if (node != null) {
			return node.getNext();
		}
		return null;
	}

	private static int addValues(Node<Integer> one,
			Node<Integer> two) {
		if (one == null) {
			return two.getData();
		} else if (two == null) {
			return one.getData();
		}

		return one.getData() + two.getData();
	}

}
