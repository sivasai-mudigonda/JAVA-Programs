/**
 * 
 */
package javapractice;

/**
 * @author SIVA SAI
 *
 */
public class QueueImplLinkList {

	/**
	 * @param args
	 */
	QNode front=null;
	QNode rear=null;
	
	public static void main(String[] args) {
		QueueImplLinkList queue= new QueueImplLinkList();
		queue.enQueue(1);
		queue.enQueue(5);
		queue.enQueue(7);
		queue.deQueue();
		queue.enQueue(9);
		queue.deQueue();
		queue.printQueue();
	}
	
	private void printQueue() {
		QNode temp=this.front;
		System.out.println("Elements in Queue are");
		while(temp!=null) {
			System.out.println(temp.key);
			temp=temp.next;
		}
	}
	
	private void enQueue(int val) {
		QNode temp=new QNode(val);
		
		if(this.rear==null) {
			this.front=this.rear=temp;
		}
		
		this.rear.next=temp;
		this.rear=this.rear.next;
		
		System.out.println("Element inserted in to Queue is "+temp.key);
	}
	
	private void deQueue() {
		
		if(this.front==null) {
			System.out.println("Queue is empty");
		}
		
		QNode temp=this.front;
		this.front=this.front.next;
		
		if(this.front==null) {
			this.rear=null;
		}
		System.out.println("Element removed from Queue is "+temp.key);
	}
	
	private class QNode{
		int key;
		QNode next;
		
		QNode(int key){
			this.key=key;
			this.next=null;
		}
	}
}
