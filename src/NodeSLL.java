
public class NodeSLL <T> {
	
	public T element; //this will be the value stored in the node, not the node itself
	public NodeSLL<T> next;
	
	
	public NodeSLL(T element) {
		//super();
		this.element = element;
		this.next = null;
	}
	
	public NodeSLL(T element, NodeSLL<T> next) {
		
		//super();
		this.element = element;
		this.next = next;
		
	}

}
