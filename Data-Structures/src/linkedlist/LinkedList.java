package linkedlist;

import nodes.Node;

/*
 *  @author: Allan J. Fret-Cruz
 *  Date: April 28, 2020
 */
public class LinkedList {
	
	Node head;
	
	public LinkedList(int value) {
		head = new Node(value);
	}
	
	
	public void preappend(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
	}

	
	public void append(int value) {
		Node newNode = new Node(value);
		Node trav = head;

		while(trav.next != null) {
			trav = trav.next;
		}
		
		trav.next = newNode;		
	}
	
	
	public boolean lookup(int value) {
		Node trav = head;
		while(trav != null) {
			if(trav.value == value) {
				return true;
			}
			trav = trav.next;
		}
		return false;
	}
	
	
	public void delete(int value) {	
		Node trav = head;
		
		if(trav.value == value)
			head = head.next;
		else {
			while(trav.next != null){
				if(trav.next.value == value){
					trav.next = trav.next.next;
				}
				trav = trav.next;
			}
		}
	}
	
	public int listSize() {
		Node curr = head;
		int size = 0;
		while(curr != null) {
			size++;
			curr = curr.next;
		}
		return size;
	}
	
	
	public void deleteNthNumber(int position) {
		Node curr = head;
		int counter = 1;
		
		while(curr != null) {
			if(counter == position - 1) {
				curr.next = curr.next.next;
			}
			curr = curr.next;
			counter++;
		}
	}
		
	
	public void printLinkedList(Node list) {
		Node curr = list;
		while(curr != null) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
	}

	
	public static void main (String[] args) {
		
		LinkedList test = new LinkedList(2);
		
		test.append(10);
		test.append(12);
		test.append(3);
		test.preappend(-4);
		test.preappend(-99);
		test.printLinkedList(test.head);
		
		System.out.println("\nDeleting the number -4");
		test.delete(-4);
		test.printLinkedList(test.head);

		System.out.println("\n\nSearching for the number 12");
		System.out.println(test.lookup(12));
		System.out.println("Searching for the number 14");
		System.out.println(test.lookup(14));
		
		System.out.println("\nSize of the list " + test.listSize());
		
		System.out.println("\nDeleting the 3th number...");
		test.deleteNthNumber(3);
		test.printLinkedList(test.head);
	}

}
