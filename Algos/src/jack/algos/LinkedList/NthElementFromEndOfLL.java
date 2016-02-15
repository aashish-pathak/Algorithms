package jack.algos.LinkedList;

public class NthElementFromEndOfLL {
	public static void main(String[] args) {
		LinkedNode root = new LinkedNode();
		LinkedList ll = new LinkedList();
		int [] in = {1,2,3,4,5,6,7,8,9,10};
		root = ll.createLinkedList(in);
		root = nthElementFromEnd(root, 10);
		if(root != null)
			System.out.println("Nth element is: " + root.value);
		else
			System.out.println("There is no element at given location.");
	}
	
	public static LinkedNode nthElementFromEnd(LinkedNode root, int n) {
		LinkedNode a,b;
		a = b = root;
		if((n == 0) || n > (lengthOfLL(root)))
			return null;
		for(int i=0; i<n-1; i++) 
			b = b.next;
		while(b.next != null) {
			b = b.next;
			a = a.next;
		}
		return a;
	}
	
	public static int lengthOfLL(LinkedNode root) {
		int l = 1;
		if((root == null) || (root.next == null))
			return 0;
		while(root.next != null) {
			root = root.next;
			l++;
		}
		return l;
	}
}
