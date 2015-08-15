package list;

public interface LinearListIntf<T> {
	public void destroyList();
	public void clearList();
	public boolean isEmpty();
	public int length();
	public T getData(int index);
	public int getIndex(T data);
	public T getPrior(T data);
	public T getNext(T data);
	public boolean setData(int index, T data);
	public boolean addData(T data);
	public boolean insertData(int index, T data);
	public boolean removeData(int index);
	public void traverse();
}
