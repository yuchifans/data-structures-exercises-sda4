package exercise;

class Node {
	int item;
	Node next;

	Node(int item, Node next) {
		this.item = item;
		this.next = next;
	}
}

public class LinkedList {
	Node first;

	public LinkedList() {
		first = null;

	}

	void add(int i) {
		Node newNode = new Node(i, null);
		if (first == null) {// list is empty
			first = newNode;
		} else {// list is not empty
			// 1. find the last node
			Node current = first;
			while (current.next != null) {
				current = current.next;
			}
			// current.next == null;
			// that means that current is the last node! YAY! :-)

			// 2. step insert new node
			current.next = newNode;
		}
	}

	/**
	 * Returns the integer element at the given index.
	 * 
	 * Complexity: 0(n)
	 * 
	 * @param index
	 * @return element at index
	 * @throws(@link IndexOutBoundsException) if Node is null
	 */
	private int get(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (first == null) {
			throw new IndexOutOfBoundsException();
		}
		int i = 0;
		Node current = first;

		while (i < index && current.next != null) {
			current = current.next;
			i++;
		}

		if (index <= i) {
			return current.item;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	private void set(int index,int item) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (first == null) {
			throw new IndexOutOfBoundsException();
		}
		int i = 0;
		Node current = first;

		while (i < index && current.next != null) {
			current = current.next;
			i++;
		}
		if (index <= i) {
			current.item=item;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	void printAll() {
		if (first == null) {
			System.out.println("[Empty]");
		} else {
			System.out.print("[");
			Node current = first;
			while (current != null && current.next != null) {
				System.out.print(current.item + ",");
				current = current.next;
			}
			System.out.print(current.item);
			System.out.println("]");
		}
	}

	/**
	 * 
	 * 
	 * @return
	 */

	int size() {
		if (first == null) {
			return 0;
		}
		int counter = 1;
		Node current = first;
		while (current.next != null) {
			counter++;
			current = current.next;
		}
		return counter++;
	}

	/**
	 * 
	 * @oaram
	 * @return
	 */

	void printAll2() {
		System.out.print("[");
		int counter = 0;
		while (counter < size()) {
			int elem = get(counter);
			System.out.print(elem);
			if (counter < size() - 1) {
				System.out.print(",");
			}
			counter++;
		}
		System.out.println("]");
	}

	public LinkedList copy() {
		if (first == null) {
			return new LinkedList();
		} else {
			LinkedList newls = new LinkedList();
			Node current = first;
			newls.first = new Node(first.item, null);
			Node currentofnew = newls.first;
			for (int i = 0; i < size() - 1; i++) {
				current = current.next;
				currentofnew.next = new Node(current.item, null);
				currentofnew = currentofnew.next;
			}
			return newls;
		}
	}

	public Node getLastNode() {
		if (first == null) {
			return null;
		} else {
			Node current = first;
			while (current.next != null) {
				current = current.next;
			}
			return current;
		}
	}

	@SuppressWarnings("null")
	public LinkedList concat(LinkedList ls) {
		if (first == null) {
			if (ls == null || ls.first == null) {
				return new LinkedList();
			} else {
				return ls.copy();
			}
		} else {
			if (ls == null || ls.first == null) {
				return copy();
			} else {
				LinkedList lst1 = copy();
				LinkedList lst2 = ls.copy();
				lst1.getLastNode().next = lst2.first;
				return lst1;
			}
		}
	}
	
	public void reverse() {
		if(first!=null) {
			LinkedList templs=copy();
			Node current = first;
			int i=size()-1;
			while(current.next!=null) {
				current.item=templs.get(i);
				current=current.next;
				i--;
			}
			current.item=templs.get(i);
		}	
	}
	
	public void reverse2() {
		if(first!=null) {
			int size=size();
			int round=size/2;
			for(int i=0;i<round;i++) {
				int tmp=get(size-1-i);
				set(size-1-i,get(i));
				set(i,tmp);
			}
		}	
	}
}
