package tree;

public interface BinaryTreeIntf <T>{
	public void inOrderTraverse(Node<T> node);
	public void preOrderTraverse(Node<T> node);
	public void postOrderTraverse(Node<T> node);
	public void inOrderTraverse2(Node<T> node);
	public void preOrderTraverse2(Node<T> node);
	public void postOrderTraverse2(Node<T> node);
	public void levelOrderTraverse(Node<T> node);
	public int getDepth(Node<T> node);
	//public int getDepth2(Node<T> node);
	public int getNodeCount(Node<T> node);
	public int getNodeCount2(Node<T> node);
	public Node<T> addNode(Node<T> parent, T value);
	public void visit(Node<T> node);
}
