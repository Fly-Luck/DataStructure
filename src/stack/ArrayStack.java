package stack;

public class ArrayStack<T> implements StackIntf<T>{

	protected int length;
	protected Object[] data;
	
	public ArrayStack(){
		data = new Object[INIT_SIZE];
	}
	
	@Override
	public boolean clearStack() {
		for(int i=0;i<length;i++){
			data[i] = null;
		}
		length = 0;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getTop() {
		if(!isEmpty()){
			return (T) data[length-1];
		} else return null;
	}

	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public int length() {
		return length;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T pop() {
		if(!isEmpty()){
			T elem = (T) data[length-1];
			data[length---1] = null;
			return elem;
		} else return null;
	}

	@Override
	public T push(T elem) {
		if(length>=data.length){
			Object[] newData = new Object[length+INCREMENT_SIZE];
			for(int i=0;i<data.length;i++){
				newData[i] = data[i];
			}
			data = newData;
		}
		data[length++] = elem;
		return elem;
	}
	
}