import java.util.Iterator;

public class DLL<T> implements ListInterface<T>, Iterable<T> {
	//Instance variables of both head and tail, since it is double linked
	NodeDLL<T> head;
	NodeDLL<T> tail;

	//Constructor
	public DLL() {
		head = null;
		tail = null;
	}

	@Override
	public void add(T t) {

		NodeDLL<T> node = new NodeDLL<T>(t, head, null);// creates a node, points to head
		if (head != null) { // if head is not null, then we set whatever comes previous to that head to
							// head.prev
			head.prev = node;
		} else {
			tail = node; // if there is no node, then the first insert is both the head and the tail
		}
		head = node;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		NodeDLL<T> current = head; // current starts at head

		while (current != null) {
			// Comparable is an interface
			if (((Comparable<T>) current.element).compareTo(t) == 0) // compare the t value (which is the nodes
																		// element), 0 is a match
			{

				if (current.prev == null) // if there is no node that comes before current, remove the head
				{
					// the value of head has to change
					head = head.next; // This means that head is now the node after current

					if (head == null) {
						tail = null; // we set tail to null if there is no head
					} else {
						head.prev = null; //
					}
				} else if (current.next == null) {// this means we are deleting the tail node
					tail = current.prev; // we set tail to whatever currents prev node was
					tail.next = null; // we set the next node after tail to null so it no longer points to current

				} else {
					// current is not the head node, so we are deleting a node between
					current.next.prev = current.prev; // modifies it so that T3 points to T1 versus T2
					current.prev.next = current.next;// modifies it so that T1 points to T3 versus T2
				}

				return;// only deletes first match, versus multiple deletes if the same name
			}

			current = current.next; // we want to point to the next node

		}
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		// create a variable of type DLL that holds objects of type T
		NodeDLL<T> node = head;
		while (node != null) {
			System.out.println(node.element.toString());// used element because it may be either a video or a customer
			node = node.next;// traverse the list
		}

	}

	public void printBack() {//I used this method only for testing purposes to see if DLL code was working correctly, testing only
		
		// create a variable of type DLL that holds objects of type T
		NodeDLL<T> node = tail;
		while (node != null) {
			System.out.println(node.element.toString());// used element because it may be either a video or a customer
			node = node.prev;// traverse the list
		}

	}

	@SuppressWarnings("unchecked")
	public T get(T t) {

		NodeDLL<T> current = head; // current starts at head

		while (current != null) // This will iterate through the nodes
		{
			// Comparable is an interface
			if (((Comparable<T>) current.element).compareTo(t) == 0) // compare the t value (which is the nodes
																		// element), 0 is a match
			{

				return current.element;

			}

			current = current.next; // navigate through link list

		}
		return null;// if no match was was found

	}

	public Iterator<T> iterator() { //Iterator is used to iterator through nodes

		return new ListIterator(head);
	}

	// @SuppressWarnings("hiding")
	class ListIterator implements Iterator<T> {
		NodeDLL<T> currentNode;

		public ListIterator(NodeDLL<T> nodeDLL) { // receive headNode from the caller
			currentNode = nodeDLL;
		}

		@Override
		public boolean hasNext() {

			return currentNode != null;// if there is another return true, retrn it

		}

		@Override
		public T next() { //iterate through nodes

			T t; // used to return data in the node

			t = currentNode.element; //t is the element, or what the node possess

			currentNode = currentNode.next;

			return t;

		}
	}

}
