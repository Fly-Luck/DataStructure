package queue;

public class LinkedListQueue<T> implements QueueIntf<T> {
	protected Node front;
	protected Node rear;
	protected int length;
	public LinkedListQueue() {
		front = new Node();
		front.setNext(null);
		rear = front;
	}

	@Override
	public boolean clearQueue() {
		while(!isEmpty()){
			dequeue();
		}
		return true;
	}

	@Override
	public T dequeue() {
		if(!isEmpty()){
			Node next = front.getNext();
			T elem = next.getData();
			front.setNext(next.getNext());
			if(null == next.getNext()){
				rear = front;
			}
			next = null;
			length--;
			return elem;
		} else return null;
	}

	@Override
	public T enqueue(T elem) {
		Node newNode = new Node(elem, null);
		rear.setNext(newNode);
		rear = newNode;
		length++;
		return elem;
	}

	@Override
	public T getFront() {
		return front.getData();
	}

	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public int length() {
		return length;
	}
	
	class Node{
		private T data;
		private Node next;
		public Node(){}
		public Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
		public T getData(){
			return data;
		}
		public void setData(T data){
			this.data = data;
		}
		public Node getNext(){
			return next;
		}
		public void setNext(Node next){
			this.next = next;
		}
	}
	public static void main(String[] args) {
		LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
	}
}
