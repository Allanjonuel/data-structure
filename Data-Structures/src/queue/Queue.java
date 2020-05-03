package queue;
import nodes.Node;

/*
 * @author Allan J. Fret-Cruz
 * Date: April 29, 2020
 */

public class Queue {
	
	Node first;
	int size;
	
	
	public Queue() {}
	
	
	public Queue(int data) {
		first = new Node(data);
		size++;
	}
	
	
	public void enqueue(int data) {
		Node newNode = new Node(data);
		if(size == 0) {
			first = newNode;
			size++;
			return;
		}
		
		Node trav = first;
		while(trav.next != null) {
			trav = trav.next;
		}
		trav.next = newNode;
		size++;
	}
	
	
	public int dequeue() {
		if(size == 0) {
			System.err.println("Queue is empty. Unable to dequeue first value.");
			System.exit(1);
		}
		int tmp = first.value;
		first = first.next;
		size--;
		return tmp;
	}
	
	
	public int peek() {
		if(size == 0) {
			System.err.println("Queue is empty. Unable to peek first value.");
			System.exit(1);
		}
		return first.value;
	}
	
	
	public void print() {
		for(Node line = this.first; line != null; line = line.next) {
			System.out.print(line.value + " ");
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		Queue line = new Queue();
		line.enqueue(10);
		line.enqueue(15);
		line.enqueue(134);
		line.enqueue(95);
		System.out.println("Printing line");
		line.print();
		System.out.println("Peek: " + line.peek());
		System.out.println("Dequeueng the first one");
		line.dequeue();
		line.print();
	}

}
