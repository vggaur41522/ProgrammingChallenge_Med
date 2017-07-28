package linkedBeast;

import java.util.HashMap;

import linkedBeast.ProblemLL.Node;

public class LRUCacheImplementation {
	HashMap<Integer, Node> map = new HashMap<>();
	private int capacity;
	private Node head = null;
	private Node tail = null;

	class Node<T> {
		int key;
		T data;
		Node next;
		Node prev;

		Node(int key, T data) {
			this.data = data;
			this.key = key;
			this.next = null;
			this.prev = null;
		}
		public void setValue(T data)
		{
			this.data = data;
		}
	}

	public LRUCacheImplementation(int capacity) {
		this.capacity = capacity;
	}

	private void removeNode(Node node)
	{
		if(head == null)
			return;
		if(head == tail)
		{
			head = null;
			tail = null;
			return;
		}
		tail = tail.prev;
		tail.next = null;
	}
	
	public void addNodeToHead(Node node)
	{
		if(head == null)
		{
			head = node;
			tail = node;
			node.next = null;
			node.prev = null;
			return;
		}
		node.next = head;
		head.prev = node;
		head = node;
		return;
	}
	
	public int get(int key) {
		if(map.containsKey(key))
		{
			Node<Integer> currNode = map.get(key);
			removeNode(currNode);
			addNodeToHead(currNode);
			return currNode.data;
		}
		else
			return -1;
	}

	public void set(int key, int data) {
		if(map.containsKey(key))
		{
			Node currNode = map.get(key);
			removeNode(currNode);
			currNode.setValue(data);
			addNodeToHead(currNode);
		}
		else
		{
			Node<Integer> currNode = new Node<>(key,data);
			if(map.size() >= capacity)
			{
				map.remove(tail.key);
				removeNode(tail);
				addNodeToHead(currNode);
			}
			else
			{
				addNodeToHead(currNode);
			}
			map.put(key, currNode);
		}
		return;
	}
	
	public void printCurrentState(Node<Integer> currNode)
	{
		if(currNode == null)
			return ;
		while(currNode != null)
		{
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {

		LRUCacheImplementation obj = new LRUCacheImplementation(4);
		obj.set(1, 10);
		obj.set(2, 20);
		obj.set(3, 30);
		obj.set(4, 40);
		obj.printCurrentState(obj.head);
		obj.set(5, 50);
		obj.printCurrentState(obj.head);
		System.out.println("\n"+obj.get(1));
		System.out.println(obj.get(2));
		obj.printCurrentState(obj.head);
		System.out.println(obj.get(3));
		obj.printCurrentState(obj.head);
	}

}
