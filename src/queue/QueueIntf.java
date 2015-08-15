package queue;

public interface QueueIntf <T>{
	public static final int INIT_SIZE = 10;
	public boolean clearQueue();
	public boolean isEmpty();
	public int length();
	public T getFront();
	public T enqueue(T elem);
	public T dequeue();
}
