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
			} else {
				return false;
			}
		}
	}

	/**
	 * Replaces the value that maps to the key only if it is present
	 * @param key The key whose mapped value is being replaced
	 * @param newValue The value to replace the existing value with
	 * @return true if the key was in this DefaultMap
	 * @throws IllegalArgumentException if the key is null
	 */
	@Override
	public boolean replace(K key, V newValue) throws IllegalArgumentException {
		if(key == null) {
			throw new IllegalArgumentException();
		}
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

	/**
	 * Remove the entry corresponding to the given key
	 * 
	 * @return true if an entry for the given key was removed
	 * @throws IllegalArgumentException if the key is null
	 */
	@Override
	public boolean remove(K key) throws IllegalArgumentException {
		if(key == null) {
			throw new IllegalArgumentException();
		}
		if(!this.containsKey(key)) {
			return false;
		}
		if(this.root.key.compareTo(key) == 0 
		&& this.root.left == null 
		&& this.root.right == null) {
			this.root = new Node<K, V>(null, null);
			this.size = 0;
			return true;
		}
		if(this.root.key.compareTo(key) == 0 
		&& this.root.left != null 
		&& this.root.right == null) {
			this.root = this.root.left;
			this.size --;
			return true;
		}
		if(this.root.key.compareTo(key) == 0 
		&& this.root.left == null 
		&& this.root.right != null) {
			this.root = this.root.right;
			this.size --;
			return true;
		}
		Node current = root;
		Node parent = null;
		while(true){
			if(current.key.compareTo(key) < 0) {
				parent = current;
				current = current.right;
			} else if(current.key.compareTo(key) > 0) {
				parent = current;
				current = current.left;
			} else {
				break;
			}
		}
		if(current.left == null && current.right == null) {
			if(current != this.root) {
				if(parent.left == null) {
					parent.right = null;
					this.size --;
					return true;
				} else if(parent.right == null) {
					parent.left = null;
					this.size --;
					return true;
				}
			}
		} else if(current.left != null) {
			parent.left = current.left;
			this.size --;
			return true;
		} else if(current.right != null) {
			parent.right = current.right;
			this.size --;
			return true;
		}
		return false;
	}

	/**
	 * Adds the key, value pair to this DefaultMap if it is not present,
	 * otherwise, replaces the value with the given value
	 * @throws IllegalArgumentException if the key is null
	 */
	@Override
	public void set(K key, V value) throws IllegalArgumentException {
		if(this.containsKey(key)){
			this.replace(key, value);
		} else {
			this.put(key, value);
		}
		
	}

	/**
	 * @return the value corresponding to the specified key
	 * @throws IllegalArgumentException if the key is null
	 */
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
			} else {
				return (V) current.value;
			}
		}
		return null;
	}

	/**
	 * 
	 * @return The number of (key, value) pairs in this DefaultMap
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * 
	 * @return true iff this.size() == 0 is true
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * @return true if the specified key is in this DefaultMap
	 * @throws IllegalArgumentException if the key is null
	 */
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
			} else {
				return true;
			}
		}
		return false;
	}

	// Keys must be in ascending sorted order
	// You CANNOT use Collections.sort() or any other sorting implementations
	// You must do inorder traversal of the tree
	/**
	 * 
	 * @return an array containing the keys of this DefaultMap. If this DefaultMap is 
	 * empty, returns array of length zero. 
	 */
	@Override
	public List<K> keys() {
		List<K> returnList = new ArrayList<K>();
		if(this.isEmpty()) {
			return returnList;
		} else {
			returnList = this.keys(this.root);
			return returnList;
		}
	}

	public List<K> keys(Node<K, V> current) {
		List<K> tempList = new ArrayList<K>();
        if (current.left != null) {
            tempList = this.keys(current.left);
        }
		tempList.add(current.getKey());
		if (root.right != null) {
            tempList = addAll(this.keys(current.left));
        }
		return tempList;
	}
	
	private static class Node<K extends Comparable<? super K>, V> implements DefaultMap.Entry<K, V> {
		private K key;
		private V value;
		private Node<K, V> left;
		private Node<K, V> right;
		
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