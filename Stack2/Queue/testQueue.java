package Queue;

/**
 * Author:QiyeSmart
 * Created:2019/7/5
 */
public class testQueue {
    //普通队列
    public static void code1(){
        MyQueue queue=new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }

    //循环队列
    public static void code2(){
        MyCircularQueue queue2=new MyCircularQueue(6);
        queue2.enQueue(1);
        queue2.enQueue(2);
        queue2.enQueue(3);
        queue2.enQueue(4);
        queue2.enQueue(5);
        System.out.println(queue2.isEmpty());
        System.out.println(queue2.Front());
        System.out.println(queue2.Rear());
    }
    public static void main(String[] args) {
        testMyQueue stack1=new testMyQueue();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.pop();
        System.out.println(stack1.top());


    }
}
