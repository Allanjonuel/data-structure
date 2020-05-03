package stack;
import nodes.Node;

/*
 * @author Allan J. Fret-Cruz
 * Date: April 29, 2020
 */

public class Stack {
	
	Node top;
	int size;
	
	
	public Stack() {}
	
	
	public Stack(int data) {
		top = new Node(data);
		size++;
	}
	
	
	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		size++;
	}
	
	
	public int pop() {
		if(size == 0) {
			System.err.println("The stack is empty. Unable to pop value.");
			System.exit(1);
		}
		int topValue = top.value;
		top = top.next;
		size--;
		return topValue;	
	}
	
	
	public int peek() {
		if(size == 0) {
			System.err.println("The stack is empty. Unable to peek value.");
			System.exit(1);
		}
		return top.value;
	}
	
	
	public void print() {
		for(Node elem = this.top; elem != null; elem = elem.next) {
			System.out.println(elem.value);
		}
	}
	
	
	public static void main(String[] args) {
		Stack test = new Stack();
		test.push(15);
		test.push(30);
		test.push(34);
		test.push(123);
		test.push(54);
		
		System.out.println("Show stack");
		test.print();
		System.out.println("Pop: " + test.pop());
		test.print();
		System.out.println("Peek: " + test.peek());
	}

}
