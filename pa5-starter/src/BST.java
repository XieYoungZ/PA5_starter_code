import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @param <K> The type of the keys of this BST. They need to be comparable by nature of the BST
 * "K extends Comparable" means that BST will only compile with classes that implement Comparable
 * interface. This is because our BST sorts entries by key. Therefore keys must be comparable.
 * @param <V> The type of the values of this BST. 
 */
public class BST<K extends Comparable<? super K>, V> implements DefaultMap<K, V> {
	/* 
	 * TODO: Add instance variables 
	 * You may add any instance variables you need, but 
	 * you may NOT use any class that implements java.util.SortedMap
	 * or any other implementation of a binary search tree
	 */
	String ILLEGAL_ARG_NULL_KEY = "Keys must be non-null";

	Node<K, V> root;
	int size;
	//Comparator<K> comparator;

	public BST() {
		this.size = 0;
		this.root = new Node<K, V>(null, null);
		//this.comparator = new Comparator<K>();
	}

	// public BST(Node<K, V> root) {
	// 	this.size = 0;
	// 	this.root = new Node<K, V>(null, null);
	// }

	/**
	 * Adds the specified key, value pair to this DefaultMap if it is not present
	 * Note: duplicate keys are not allowed
	 * 
	 * @return true if the key value pair was added to this DefaultMap
	 * @throws IllegalArgumentException if the key is null
	 */
	@Override
	public boolean put(K key, V value) throws IllegalArgumentException {
		if(key == null) {
			throw new IllegalArgumentException();
		}
		if(this.root.key == null){
			this.root.key = key;
			this.root.value = value;
			this.size += 1;
			return true;
		} else if (this.root.key.equals(key)){
			return false;
		}
		Node current = this.root;
		while(true) {
			if(current.key.compareTo(key) < 0) {
				if(current.right == null) {
					current.right = new Node<K, V>(key, value);
					this.size += 1;
					return true;
				} else {
					current = current.right;
				}
			} else if(current.key.compareTo(key) > 0) {
				if(current.left == null) {
					current.left = new Node<K, V>(key, value);
					this.size += 1;
					return true;
				} else {
					current = current.left;
				}
			}
			return false;
		}
	}

	@Override
	public boolean replace(K key, V newValue) throws IllegalArgumentException {
		if(key == null) {
			throw new IllegalArgumentException();
		}
		// if(newValue == null) {
		// 	return false;
		// }
		if(this.containsKey(key)){
			if(this.root.key == key){
				this.root.setValue(newValue);
				return true;
			}
			Node current = this.root;
			while(current != null){
				if(current.key.compareTo(key) < 0) {
					if(current.right.key.equals(key)){
						current.right.setValue(newValue);
						return true;
					} else {
						current = current.right;
					}
				} else if(current.key.compareTo(key) > 0) {
					if(current.left.key.equals(key)){
						current.left.setValue(newValue);
						return true;
					} else {
						current = current.left;
					}
				}
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean remove(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void set(K key, V value) throws IllegalArgumentException {
		if(this.containsKey(key)){
			this.replace(key, value);
		} else {
			this.put(key, value);
		}
		
	}

	@Override
	public V get(K key) throws IllegalArgumentException {
		if(key == null) {
			throw new IllegalArgumentException();
		}
		if(!this.containsKey(key)) {
			return null;
		}
		if(this.root.key.equals(key)) {
			return this.root.value;
		}
		Node current = this.root;
		while(current != null){
			if(current.key.compareTo(key) < 0) {
				if(current.right.key.equals(key)){
					return (V) current.right.value;
				} else {
					current = current.right;
				}
			} else if(current.key.compareTo(key) > 0) {
				if(current.left.key.equals(key)){
					return (V) current.left.value;
				} else {
					current = current.left;
				}
			}
			return null;
		}
		return null;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public boolean containsKey(K key) throws IllegalArgumentException {
		if(key == null) {
			throw new IllegalArgumentException();
		}
		if(this.root.key == null) {
			return false;
		}
		if(this.root.key == key) {
			return true;
		}
		Node current = this.root;
		while(current != null){
			if(current.key.compareTo(key) < 0) {
				if(current.right == null) {
					return false;
				} else if(current.right.key != key){
					current = current.right;
				} else {
					return true;
				}
			} else if(current.key.compareTo(key) > 0) {
				if(current.left == null) {
					return false;
				} else if(current.left.key != key){
					current = current.left;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	// Keys must be in ascending sorted order
	// You CANNOT use Collections.sort() or any other sorting implementations
	// You must do inorder traversal of the tree
	@Override
	public List<K> keys() {
		ArrayList<K> returnList = new ArrayList<K>();
		if(this.isEmpty()) {
			return (List) returnList;
		} else {
			keysIndexHelper(root, returnList, 0);
			return (List) returnList;
		}
	}

	public int keysIndexHelper(Node root, ArrayList<K> returnList, int index) {
        if (root.left != null) {
            index = (int) keysIndexHelper(root.left, returnList, index);
        }
        returnList.add(index++, (K) root.value);
        if (root.right != null) {
            index = (int) keysIndexHelper(root.right, returnList, index);
        }
		return index;
	}
	
	private static class Node<K extends Comparable<? super K>, V> implements DefaultMap.Entry<K, V> {
		private K key;
		private V value;
		Node<K, V> left;
		Node<K, V> right;
		
		public Node(K key, V value){
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}

		@Override
		public K getKey() {
			return this.key;
		}

		@Override
		public V getValue() {
			return this.value;
		}

		@Override
		public void setValue(V value) {
			this.value = value;
		}
		
		
	}
	 
}