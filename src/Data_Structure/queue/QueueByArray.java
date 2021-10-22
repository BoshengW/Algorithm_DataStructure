package Data_Structure.queue;

/**
 * 利用Array来实现queue会要考虑"溢出问题"，但是利用链表实现可以避免
 *
 * */
public class QueueByArray {
    int[] queue;
    int head;
    int tail; // check array reach maxsize or not
    int maxsize=20; // maxsize of array

    public QueueByArray() {
        this.head = 0;
        this.tail = 0;
        this.queue = new int[maxsize];
    }

    public void enqueue(int item) {
        this.queue[++this.tail] = item;
        if(this.tail>=this.maxsize) {
            extendCap();
        }

    }

    public int dequeue(int item) {
        //if head touch tail
        if(this.head==this.tail) {
            System.out.println("no element inside the Data_Structure.queue");
            return 0;
        }
        int popVal = this.queue[this.head];
        this.head++;

        return popVal;

    }

    public void extendCap() {
        // extend array capacity
        // if Data_Structure.queue is full, no necessary to extend in Queue
        maxsize = 2 * maxsize;
        int[] temp = new int[maxsize];
        for(int i=0; i<this.queue.length; i++) {

            temp[i] = this.queue[i];

        }
        this.queue = temp;

    }

}
