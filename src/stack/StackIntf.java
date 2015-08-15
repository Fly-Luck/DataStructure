package stack;

public interface StackIntf <T>{
	public static final int INIT_SIZE = 10;
	public static final int INCREMENT_SIZE = 10;
	public boolean clearStack();
	public boolean isEmpty();
	public int length();
	public T getTop();
	public T push(T elem);
	public T pop();
}
