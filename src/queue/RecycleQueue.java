package queue;

public class RecycleQueue<T> implements QueueIntf<T> {
	protected int front, rear;
	T[] data;
	public RecycleQueue(){
		this(INIT_SIZE);
	}
	@SuppressWarnings("unchecked")
	public RecycleQueue(int size){
		data = (T[]) new Object[size];
		rear = front = 0;
	}
	@Override
	public boolean clearQueue() {
		for(int i=0;i<data.length;i++){
			data[i] = null;
		}
		data = null;
		rear = front = 0;
		return true;
	}

	@Override
	public T dequeue() {
		if(!isEmpty()){
			T elem = data[front];
			front = (front+1)%data.length;
			return elem;
		} else return null;
	}

	@Override
	public T enqueue(T elem) {
        if((rear+1)%data.length==front){  
        	return null;
        }else{
        	data[rear]=elem;  
        	rear=(rear+1)%data.length;
        	return elem;
        }  
	}

	@Override
	public T getFront() {
		if(!isEmpty()){
			return data[front];
		} else return null;
	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	@Override
	public int length() {
		if(rear >= front){
			return rear-front;
		} else {
			return data.length-(front-rear)+1;
		}
	}
	
	public static void main(String[] args) {
		RecycleQueue<Integer> queue = new RecycleQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
	}

}
