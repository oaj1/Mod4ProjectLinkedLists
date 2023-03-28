
public class NodeDLL <T>{
	
	T element;
	NodeDLL<T> next;
	NodeDLL<T> prev;
	
	public NodeDLL(T element) {
		//super();
		this.element = element;
		this.next = null;
		this.prev = null;
	}
	

	public NodeDLL(T element, NodeDLL<T> next, NodeDLL<T> prev) {
		
		//super();
		this.element = element;
		this.next = next;
		this.prev = prev;
		
	}

}
