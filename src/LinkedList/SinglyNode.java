package LinkedList;

public class SinglyNode {

	private Object elementInsideNode;
	private SinglyNode next;

	public SinglyNode() {
	}

	public SinglyNode(Object elementInsideNode) {
		super();
		this.elementInsideNode = elementInsideNode;
	}
	public Object getElementInsideNode() {
		return elementInsideNode;
	}
	public void setElementInsideNode(Object elementInsideNode) {
		this.elementInsideNode = elementInsideNode;
	}
	public SinglyNode getNext() {
		return next;
	}
	public void setNext(SinglyNode next) {
		this.next = next;
	}
}
