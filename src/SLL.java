import java.util.Iterator;


public class SLL<T> implements ListInterface <T>, Iterable<T>{
	//instance variable head
	NodeSLL<T> head;
	
	public SLL()
	{
		head = null;
		
		}

	//add generic type T, whether video or customer, add points that node to head
	@Override
	public void add(T t) {
		
		NodeSLL <T> node = new NodeSLL<T>(t,head);
		head = node;
		
		
		
	}


	@SuppressWarnings("unchecked")
	public void delete(T t) {
		
		NodeSLL <T> current = head;	//	current starts at head
		NodeSLL <T> previous = null;//previous starts as null
		
		
		while (current != null)  //while there are nodes
		{
			//Comparable is an interface
			if (((Comparable<T>) current.element).compareTo(t)==0) //compare the t value (which is the nodes element), 0 is a match
			{
				
				if (previous == null) 
				{
					//the value of head has to change
					head = head.next;
				}else 
				{
					previous.next = current.next; // previous.next, points to current.next node
				}
				return;//only deletes first match, versus multiple deletes if the same name
			}
			//we want to find a match and traverse through nodes
			//we want to keep previous to point to former node.
			previous = current; //starts by pointing to current
			current = current.next; //we want to point to the next node
			
			
		
		}
			
		
		
		
	}
	

	@Override
	public void print() {
		// TODO Auto-generated method stub
		//create a variable of type SLL that holds objects of type T
		NodeSLL  <T> node = head;
		while (node != null) {
			System.out.println(node.element.toString());//used element because it may be either a video or a customer
			node = node.next;//traverse the list
		}
		
	}

	
	@SuppressWarnings("unchecked")
	public T get (T t) { //get a video or customer
		
		
		NodeSLL <T> current = head;	//	current starts at head
		
		while (current != null) //This will iterate through the nodes
		{
			//Comparable is an interface
			if (((Comparable<T>) current.element).compareTo(t)==0) //compare the t value (which is the nodes element), 0 is a match
			{
				
				return current.element;
				
			}
			
			current = current.next; //navigate through link list
			
			
		
		}
		return null;//if no match was was found
		
		
		
	}

	
	public Iterator<T> iterator() {

		return new ListIterator(head);
	}

	// @SuppressWarnings("hiding")
	class ListIterator implements Iterator<T> {
		NodeSLL<T> currentNode;

		public ListIterator(NodeSLL<T> nodeSLL) { // receive headNode from the caller
			currentNode = nodeSLL;
		}

		@Override
		public boolean hasNext() {

			return currentNode != null;// if there is another return true

		}

		@Override
		public T next() {

			T t; // used to return data in the node

			t = currentNode.element;

			currentNode = currentNode.next;

			return t;

		}
	}

	

}
