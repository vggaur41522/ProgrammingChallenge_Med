package linkedBeast;

public class ProblemLL<T> {

	private boolean isDoubleLL;
	private Node head = null;
	private Node tail = null;

	protected class Node<T> {
		T data;
		Node next;
		Node prev;

		protected Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	ProblemLL(boolean isDoubleLL) {
		this.isDoubleLL = isDoubleLL;
	}

	public void insertInDoubly(int[] test) {
		for (int i : test) {
			Node n = new Node(i);
			if (head == null) {
				head = n;
				tail = n;
				continue;
			}
			n.next = head;
			head.prev = n;
			head = n;
		}
	}

	public void insertInSingly(int[] test) {
		for (int i : test) {
			Node n = new Node(i);
			if (head == null) {
				head = n;
				tail = n;
				continue;
			}
			n.next = head;
			head = n;
		}
	}

	public void insertFromArray(int[] test) {
		System.out.println("Is DOUBLY : " + isDoubleLL);
		if (isDoubleLL)
			insertInDoubly(test);
		else
			insertInSingly(test);
	}
	public void deleteFromTailDoubly()
	{
		if(head == null)
		{
			System.out.println("LL is empty");
			return;
		}
		if(tail == head)
		{
			head = null;
			tail = null;
			return;
		}
		tail = tail.prev;
		tail.next = null;
		return;
	}
	public void printLL(Node node){
		if(node == null)
			return;
		System.out.print(node.data + " ");
		printLL(node.next);
	}
	public void deleteFromTailSingly()
	{
		if(head == null)
		{
			System.out.println("SINGLE LL IS EMPTY");
		}
		if(head.next == null)
			head = null;
		Node currNode = head;
		Node prevNode = null;
		while(currNode.next != null)
		{
			prevNode = currNode;
			currNode = currNode.next;
		}
		prevNode.next = null;
		return;
	}
	public void deleteFromLL()
	{
		if(isDoubleLL)
			deleteFromTailDoubly();
		else
			deleteFromTailSingly();
	}
	public static void main(String[] args) {
		// Integer Singly LL
		ProblemLL pbSingInt = new ProblemLL<Integer>(true);

		int[] test = new int[] { 1, 2, 3, 4, 5 };
		pbSingInt.insertFromArray(test);
		pbSingInt.printLL(pbSingInt.head);
		pbSingInt.deleteFromLL();
		System.out.println("");
		pbSingInt.printLL(pbSingInt.head);
		/* Now that we have our LinkedList Ready. Lets do some diff problems */
		System.out.println("");
		pbSingInt.printLL(pbSingInt.reverseLL(pbSingInt.head));
		
		
		ProblemLL<Integer> pbSingle1 = new ProblemLL<>(false);
		ProblemLL<Integer> pbSingle2 = new ProblemLL<>(false);
		pbSingle1.insertFromArray(new int[] { 5,4,3,2,1});
		pbSingle2.insertFromArray(new int[] { 5,4,3,10 });
		ProblemLL<Integer> pb = new ProblemLL<>(false);
		System.out.println("Intersection :"+pb.findIntersection(pbSingle1.head, pbSingle2.head));
	}
	public int findLen(Node node)
	{
		if(node == null)
			return 0;
		int count = 0;
		while(node != null)
		{
			count++;
			node = node.next;
		}
		return count;
	}
	public int findIntersectionUtil(Node<Integer> n1, Node<Integer> n2, int l1, int l2)
	{
		// Move L1
		for(int i=0;i < l1-l2;i++)
		{
			if(n1 == null)
				return -1;
			n1 = n1.next;
		}
		while(n1 != null && n2 != null)
		{
			if(n1.data == n2.data)
				return n1.data;
			n1 = n1.next;
			n2 = n2.next;
		}
		return -1;
	}
	public int findIntersection(Node head1, Node head2)
	{
		if(head1 == null ||  head2 == null)
			return -1;
		
		int len1 = findLen(head1);
		int len2 = findLen(head2);
		return (len1 > len2)?findIntersectionUtil(head1, head2,len1,len2) :findIntersectionUtil(head2, head1,len2,len1); 
	}
	public Node reverseLL(Node node)
	{
		if(node == null)
			return null;
		Node prevNode = null;
		Node nextNode = node;
		Node currNode = node;
		while(currNode != null)
		{
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		return prevNode;
	}
	

}
