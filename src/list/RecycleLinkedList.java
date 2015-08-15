package list;

public class RecycleLinkedList<T> extends LinkedList<T>{
	public RecycleLinkedList() {
		head = tail = null;
	}
	public RecycleLinkedList(T data){
		tail = head = new Node(data, null, null);
		length++;
	}

	@Override
	public boolean addData(T data) {
		Node newNode = new Node(data, tail, head);
		if(null == tail){
			head = tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		length++;
		return true;
	}
	
	@Override
	public boolean addDataHead(T data) {
		Node newNode = new Node(data, tail, head);
		if(null == head){
			tail = head = newNode;
		} else {
			head.setPrior(newNode);
			head = newNode;
		}
		if(null == tail){
			tail = head;
		}
		length++;
		return true;
	}
	
	@Override
	public boolean removeData(int index) {
		if(index < 0 || index > length - 1){
			return false;
		} else if(0 == index){
			head = head.getNext();
			head.setPrior(tail);
			tail.setNext(head);
			length--;
			return true;
		} else if(length - 1 == index){
			tail = tail.getPrior();
			tail.setNext(head);
			head.setPrior(tail);
			length--;
			return true;
		} else {
			Node node = getNode(index);
			Node prior = node.getPrior();
			Node next = node.getNext();
			prior.setNext(next);
			next.setPrior(prior);
			length--;
			return true;
		}
	}
	
	public static void main(String[] args) {
		RecycleLinkedList<Integer> list = new RecycleLinkedList<Integer>();
		list.addData(1);
		list.addData(2);
		list.addData(3);
		list.addData(4);
		System.out.println("current:");
		list.traverse();
		list.getData(0);
		list.getData(1);
		list.getData(2);
		list.getData(3);
		list.removeData(3);
		list.removeData(2);
		list.removeData(1);
		list.removeData(0);
		System.out.println("\ncurrent:");
		list.traverse();
		list.addDataHead(4);
		list.addDataHead(3);
		list.addDataHead(2);
		list.addDataHead(1);
		System.out.println("\ncurrent:");
		list.traverse();
	}
}
