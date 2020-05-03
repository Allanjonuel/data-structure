package doublylinkedlist;

import nodes.DoublyLinkedList;

public class DoublyLinkedListApp {
	
	DoublyLinkedList head;
	DoublyLinkedList tail;
	
	public DoublyLinkedListApp() {}
	
	public DoublyLinkedListApp(int value) {
		head = new DoublyLinkedList(value);
	}
	
	public void append(int value) {
		DoublyLinkedList newNode = new DoublyLinkedList(value);
		if(head == null) {
			head = newNode;
			return;
		}
		DoublyLinkedList trav = head;
		while(trav.next != null) {
			trav = trav.next;
		}
		newNode.next = trav.next;
		newNode.prev = trav;
		trav.next = newNode;
		tail = newNode;
	} // end of append
	
	public void preappend(int value) {
		DoublyLinkedList newNode = new DoublyLinkedList(value);
		if(head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}
	
	public void deleteNode(int position) {
		if(head.next == null && position == 1) {
			head = null;
			return;
		}
		
		int count = 1;
		DoublyLinkedList trav = head;
		while(trav.next != null && count <= position - 1) {
			trav = trav.next;
			count++;
		}
		
		// if node to delete is the last one
		if(trav.next == null) {
			trav.prev.next = null;
			tail = trav.prev;
			return;
		}
		
		trav.prev.next = trav.next;
		trav.next.prev = trav.prev;
	}
	
	
	public void printDoublyLinkedList(DoublyLinkedList list) {
		for(DoublyLinkedList trav = list; trav != null; trav = trav.next){
			System.out.print(trav.value + " ");
		}
		System.out.println();
	}
	
	// does not print the whole list. Fix it
	public void printTailDoublyLinkedList(DoublyLinkedList t) {
		for(DoublyLinkedList trav = t; trav != null; trav = trav.prev){
			System.out.print(trav.value + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		DoublyLinkedListApp test = new DoublyLinkedListApp();
		test.preappend(3);
		test.append(10);
		test.append(3);
		test.append(34);
		test.append(45);
		test.append(23);
		test.append(4);
		test.printDoublyLinkedList(test.head);
		System.out.println();
		System.out.println("Delete the Node 3");
		test.deleteNode(3);
		test.printDoublyLinkedList(test.head);
		System.out.println("Preappend: 109");
		test.preappend(109);
		test.printDoublyLinkedList(test.head);
		System.out.println("Iterating the list backwards");
		test.printTailDoublyLinkedList(test.tail);
		System.out.println("Preappend: 33");
		test.preappend(33);
		test.printDoublyLinkedList(test.head);
	}
	
} // end of class
