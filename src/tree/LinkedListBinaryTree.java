package tree;

import list.LinkedList;
import queue.LinkedListQueue;
import stack.ArrayStack;

public class LinkedListBinaryTree <T> implements BinaryTreeIntf <T>{

	private Node<T> root;
	
	public LinkedListBinaryTree() {
		root = null;
	}
	public LinkedListBinaryTree(T value){
		root = new Node<T>(value);
	}
	
	public Node<T> getRoot(){
		return root;
	}
	
	@Override
	public Node<T> addNode(Node<T> parent, T value){
		if(null == parent){
			return null;
		}
		Node<T> newNode = new Node<T>(value);
		if(null == parent.getLeftChild()){
			parent.setLeftChild(newNode);
		} else {
			parent.setRightChild(newNode);
		}
		return newNode;
	}
	
	@Override
	public int getDepth(Node<T> node) {
		if(null == node){
			return 0;
		}
		int leftDepth = getDepth(node.getLeftChild());
		int rightDepth = getDepth(node.getRightChild());
		return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
	}
	
	@Override
	public int getNodeCount(Node<T> node) {
		if(null == node){
			return 0;
		}
		return getNodeCount(node.getLeftChild()) + getNodeCount(node.getRightChild()) + 1;
	}
	
	@Override
	public int getNodeCount2(Node<T> node) {
		if(null == node){
			return 0;
		}
		int count = 1;
		LinkedListQueue<Node<T>> queue = new LinkedListQueue<Node<T>>();
		queue.enqueue(root);
		while(!queue.isEmpty()){
			Node<T> current = queue.dequeue();
			if(current.getLeftChild() != null){
				queue.enqueue(current.getLeftChild());
				count++;
			}
			if(current.getRightChild() != null){
				queue.enqueue(current.getRightChild());
				count++;
			}
		}
		return count;
		
	}
	
	@Override
	public void visit(Node<T> node) {
		if(null == node) return;
		System.out.print(node.getValue());
	}

	@Override
	public void inOrderTraverse(Node<T> node) {
		if(null == node){
			return;
		}
		inOrderTraverse(node.getLeftChild());
		visit(node);
		inOrderTraverse(node.getRightChild());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void inOrderTraverse2(Node<T> node) {
		ArrayStack<Node<Integer>> stack = new ArrayStack<Node<Integer>>();
		while(null != node || !stack.isEmpty()){
			while(null != node){
				stack.push((Node<Integer>) node);
				node = node.getLeftChild();
			}
			if(!stack.isEmpty()){
				node = (Node<T>) stack.pop();
				System.out.print(node.getValue());
				node = node.getRightChild();
			}
		}
	}
	
	@Override
	public void postOrderTraverse(Node<T> node) {
		if(null == node){
			return;
		}
		postOrderTraverse(node.getLeftChild());
		postOrderTraverse(node.getRightChild());
		visit(node);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void postOrderTraverse2(Node<T> node) {
		ArrayStack<Node<Integer>> stack = new ArrayStack<Node<Integer>>();
		ArrayStack<Node<Integer>> stack2 = new ArrayStack<Node<Integer>>();
		Integer i = new Integer(1);
		while(null != node || !stack.isEmpty()){
			while(null != node){
				stack.push((Node<Integer>) node);
				stack2.push(new Node<Integer>(0));
				node = node.getLeftChild();
			}
			while(!stack2.isEmpty() && stack2.getTop().getValue().equals(i)){
				stack2.pop();
				System.out.print(stack.pop().getValue());
			}
			if(!stack.isEmpty()){
				stack2.pop();
				stack2.push(new Node<Integer>(1));
				node = (Node<T>) stack.getTop();
				node = node.getRightChild();
			}
		}
	}
	
	@Override
	public void preOrderTraverse(Node<T> node) {
		if(null == node){
			return;
		}
		visit(node);
		preOrderTraverse(node.getLeftChild());
		preOrderTraverse(node.getRightChild());
	}
	
	@Override
	public void preOrderTraverse2(Node<T> node) {
		ArrayStack<Node<T>> stack = new ArrayStack<Node<T>>();
		while(null != node || !stack.isEmpty()){
			while(null != node){
				System.out.print(node.getValue());
				stack.push((Node<T>) node);
				node = node.getLeftChild();
			}
			if(!stack.isEmpty()){
				node = (Node<T>) stack.pop();
				node = node.getRightChild();
			}
		}
	}
	
	@Override
	public void levelOrderTraverse(Node<T> node) {
		if(null == node){
			return;
		}
		LinkedList<Node<T>> list = new LinkedList<Node<T>>();
		list.addData(node);
		int current = 0, last = 1;
		while(current < list.length()){
			last = list.length();
			while(current < last){
				System.out.print(list.getData(current).getValue());
				if(list.getData(current).getLeftChild() != null){
					list.addData(list.getData(current).getLeftChild());
				}
				if(list.getData(current).getRightChild() != null){
					list.addData(list.getData(current).getRightChild());
				}
				current++;
			}
			System.out.println();
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		LinkedListBinaryTree<Integer> tree = new LinkedListBinaryTree<Integer>(1);
		Node<Integer> n1 = tree.addNode(tree.getRoot(), 2);
		Node<Integer> n2 = tree.addNode(tree.getRoot(), 3);
		Node<Integer> n3 = tree.addNode(n1, 4);
		Node<Integer> n4 = tree.addNode(n1, 5);
		Node<Integer> n5 = tree.addNode(n2, 6);
		Node<Integer> n6 = tree.addNode(n2, 7);
		Node<Integer> n7 = tree.addNode(n3, 8);
		Node<Integer> n8 = tree.addNode(n3, 9);
		System.out.println("Pre-order:");
		tree.preOrderTraverse(tree.getRoot());
		System.out.println("\nIn-order:");
		tree.inOrderTraverse(tree.getRoot());
		System.out.println("\nPost-order:");
		tree.postOrderTraverse(tree.getRoot());
		System.out.println("\nPre-order2:");
		tree.preOrderTraverse2(tree.getRoot());
		System.out.println("\nIn-order2:");
		tree.inOrderTraverse2(tree.getRoot());
		System.out.println("\nPost-order2:");
		tree.postOrderTraverse2(tree.getRoot());		
		System.out.println("\nLevel-order:");
		tree.levelOrderTraverse(tree.getRoot());
		System.out.println("\nDepth:"+tree.getDepth(tree.getRoot()));
		//System.out.println("Depth2:"+tree.getDepth2(tree.getRoot()));
		System.out.println("Nodes:"+tree.getNodeCount(tree.getRoot()));
		System.out.println("Nodes2:"+tree.getNodeCount2(tree.getRoot()));
		
	}
}
class Node<T>{
	private T value;
	private Node<T> leftChild, rightChild;
	public Node(){}
	public Node(T value){
		this.value = value;
		rightChild = leftChild = null;
	}
	public Node(T value, Node<T> leftChild, Node<T> rightChild){
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	public T getValue(){return value;}
	public void setValue(T value){this.value = value;}
	public Node<T> getLeftChild(){return leftChild;}
	public void setLeftChild(Node<T> leftChild){this.leftChild = leftChild;}
	public Node<T> getRightChild(){return rightChild;}
	public void setRightChild(Node<T> rightChild){this.rightChild = rightChild;};
}
