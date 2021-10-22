package Data_Structure.queue;


class LinkNode<T> {
    T val;
    LinkNode<T> next;

    public LinkNode(T val) {
        this.val = val;
        // default next=null
    }
}

public class QueueByLinklist<T> {

    private LinkNode<T> head;
    private LinkNode<T> tail;
    private int length;

    public QueueByLinklist() {
        this.length = 0;
        this.head = new LinkNode(-1);
        this.tail = this.head;
    }

    public void enqueue(T val) {
        LinkNode<T> newNode = new LinkNode(val);
        this.tail.next = newNode;
        this.tail = this.tail.next;

        this.length+=1;
    }

    public void dequeue() {
        if(this.isEmpty()) {
            System.out.println("Queue is Empty");
        }
        this.head.next = this.head.next.next;
        this.length -= 1;
    }

    public T peek() {
        return (T)this.head.next.val;
    }

    public boolean isEmpty() {
        return this.length==0;
    }

    public void printQueue() {
        LinkNode<T> pre = this.head;
        for(int i=0; i<this.length; i++) {
            pre = pre.next;
            System.out.println(pre.val);
        }
    }

    public static void main(String[] args) {
        QueueByLinklist<Integer> obj = new QueueByLinklist<Integer>();
        obj.enqueue(1);
        obj.enqueue(2);

        System.out.println(obj.peek());

        obj.dequeue();
        System.out.println(obj.peek());
    }

}
