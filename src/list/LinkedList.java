package list;

public class LinkedList<T> implements LinearListIntf<T>{

	protected Node head, tail;
	protected int length;

	public LinkedList(){
		tail = head = null;
	}
	public LinkedList(T data){
		this.head = new Node(data, null, null);
		this.tail = head;
		this.length ++;
	}
	
	public Node getHead(){
		return head;
	}
	public Node getTail(){
		return tail;
	}
	
	@Override
	public void clearList() {
		Node current = head;
		Node next = null;
		if(null != current){
			while(null != (next = current.getNext())){
				current = null;
				current = next;
			}
		}
	}

	@Override
	public void destroyList() {
		
	}
	
	@Override
	public void traverse(){
		Node current = head;
		for(int i=0;i<length;i++){
			System.out.print(current.getData());
			current = current.getNext();
		}
	}
	
	@Override
	public boolean isEmpty() {
		return length==0;
	}

	@Override
	public int length() {
		return length;
	}
	
	public Node getNode(int index){
		if(index < 0 || index > length - 1){
			return null;
		}
		Node current = head;
		for(int i=0;i<index;i++){
			current = current.getNext();
		}
		return current;
	}
	
	@Override
	public boolean addData(T data) {
		Node newNode = new Node(data, tail, null);
		if(null == tail){
			head = tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;			
		}
		length++;
		return true;
	}
	
	public boolean addDataHead(T data){
		Node newNode = new Node(data, null, head);
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
	
	public boolean insertData(int index, T data) {
		if(index < 0 || index > length - 1){
			return false;
		} else if(0 == index){
			return addDataHead(data);
		} else if(index == length - 1){
			return addData(data);
		} else {
			Node next = getNode(index);
			Node prior = next.getPrior();
			Node newNode = new Node(data, prior, next);
			prior.setNext(newNode);
			next.setPrior(newNode);
			length++;
			return true;
		}
	}
	
	@Override
	public T getData(int index) {
		return getNode(index).getData();
	}
	
	@Override
	public boolean removeData(int index) {
		if(index < 0 || index > length - 1){
			return false;
		} else if(0 == index){
			head = head.getNext();
			if(null != head){
				head.setPrior(null);
			}
			length--;
			return true;
		} else if(length - 1 == index){
			tail = tail.getPrior();
			if(null != tail){
				tail.setNext(null);
			}
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

	@Override
	public boolean setData(int index, T data) {
		return false;
	}	

	@Override
	public int getIndex(T data) {
		for(int i = 0;i<length;i++){
			if(data.equals(getNode(i).getData()))
				return i;
		}
		return -1;
	}

	@Override
	public T getNext(T data) {
		Node current = head;
		for(int i = 0; i<length;i++){
			if(current.getData().equals(data)){
				if(null != current.getNext()){
					return current.getNext().getData();
				} else {
					return null;
				}
			}
			current = current.getNext();
		}
		return null;
	}

	@Override
	public T getPrior(T data) {
		Node current = head;
		for(int i = 0; i<length;i++){
			if(current.getData().equals(data)){
				if(null != current.getPrior()){
					return current.getPrior().getData();
				} else {
					return null;
				}
			}
			current = current.getNext();
		}
		return null;
	}
	
	class Node{
		private T data;
		private Node prior;
		private Node next;
		public Node(T data, Node prior, Node next){
			this.data = data;
			this.prior = prior;
			this.next = next;
		}
		public Node() {
			// TODO Auto-generated constructor stub
		}
		public T getData(){
			return data;
		}
		public void setData(T data){
			this.data = data;
		}
		public Node getPrior(){
			return prior;
		}
		public void setPrior(Node prior){
			this.prior = prior;
		}
		public Node getNext(){
			return next;
		}
		public void setNext(Node next){
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
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
