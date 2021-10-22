package Data_Structure.queue;

/**
 * 因为纯数组会存在溢出问题，但是如果利用循环链表就可以避免这个问题
 * 纯数组实现会存在"假溢出"问题，tail指向了尾部，但是其实数组并没有满，这样极其浪费空间
 *
 * - Solution: 构建一个循环向量空间 - 首尾相连
 * */
public class CircleQueue {
    /**
     * int head, tail
     * if tail touch maxsize -> tail % maxsize back to head part
     * -> overflow condition: tail+1 % maxsize >=head
     * */

    int head;
    int tail;
    int maxsize;
    int[] queue;

    public CircleQueue(int maxsize) {
        this.head=this.tail=0;
        this.maxsize = maxsize;
        this.queue = new int[maxsize];
    }

    public void enqueue(int item) {
        //check Data_Structure.queue is full
        if((this.tail+1) % this.maxsize==head) {
            // avoid if Data_Structure.queue is empty, head touch tail
            System.out.println("Data_Structure.queue is full");
            return;
        }

        this.queue[this.tail] = item;
        this.tail = (this.tail+1) % this.maxsize;

    }

    public int dequeue() {
        // how to check when circle Data_Structure.queue is empty
        if(this.head==this.tail) {
            System.out.println("Data_Structure.queue is empty");
            return -1;
        }
        int popVal = this.queue[this.head];
        this.head = (this.head+1)%this.maxsize;

        return popVal;
    }

    // question 如何对当前circle queue进行扩容
    public void extendCapcity() {

        int[] temp = new int[2*this.maxsize];
        int idx = 0;
        while(this.head!=this.tail) {
            temp[idx] = this.queue[this.head];
            this.head++;
            if(this.head==maxsize) {
                this.head = this.head % maxsize;
            }
            idx++;
        }
        this.maxsize = 2 * this.maxsize;
        this.queue = temp;
        this.head = 0;
        this.tail = idx + 1;

    }




}
