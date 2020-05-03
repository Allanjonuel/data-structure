package nodes;

/*
 * @Author: Allan J. Fret-Cruz
 * Date: April 29, 2020
 */
public class DoublyLinkedList {
	
	public DoublyLinkedList prev;
	public DoublyLinkedList next;
	public int value;
	
	public DoublyLinkedList() {}
	
	public DoublyLinkedList(int value) {
		this.value = value;
	}
		
}
