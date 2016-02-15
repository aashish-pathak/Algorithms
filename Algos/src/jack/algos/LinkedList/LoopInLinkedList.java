package jack.algos.LinkedList;

public class LoopInLinkedList {
	public static void main(String[] args) {
		LinkedNode root = new LinkedNode();
		LinkedList ll = new LinkedList();
		int [] in = {1,2,3,4,5};
		root = ll.createLinkedList(in);
		//root = createLoop(root);
		
		if(ifLoopExist(root))
			System.out.println("Loop exists in Linked List");
		else
			System.out.println("Loop does not exists in Linked List");
		
	}
	
	public static LinkedNode createLoop(LinkedNode node) {
		LinkedNode start = new LinkedNode();
		start = node;
		while(node.next != null)
			node = node.next;
		node.next = start;
		return node; 
	}
	
	public static Boolean ifLoopExist(LinkedNode root) {
		LinkedNode fast , slow;
		slow = fast = root;
		while((fast != null) && (fast.next != null)) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)
				return true;
		}
		/*
		 * NOTE: If there is no loop in the LL, Middle element will be slow pointer node.
		 */
		System.out.println("Middle: " + slow.value);
		return false;
	}
}
