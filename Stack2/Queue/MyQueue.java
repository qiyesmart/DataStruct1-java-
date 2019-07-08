package Queue;

/**
 * Author:QiyeSmart
 * Created:2019/7/5
 */
public class MyQueue implements  IsQueue {
    class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
         }
    }
    private Node front;
    private Node rear;
    private int usedSize;
    public MyQueue(){
        this.front=null;
        this.rear=null;
        this.usedSize=0;
    }
    // 判断这个队列是否为空
    public boolean empty(){
       return this.usedSize==0;
    }
    // 返回队首元素，但不出队列
    public  int peek(){
      if(empty()){
          throw new UnsupportedOperationException("队列为空");
      }
      return this.front.data;
    }
    // 返回队首元素，并且出队列
    public int poll(){
        if(empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        int oldData=this.front.data;
        this.front=this.front.next;
        this.usedSize--;
        return oldData;
    }
    // 将 item 放入队列中
    public void add(int item){
        Node node=new Node(item);
        if(this.front==null){
            this.front=node;
            this.rear=node;
        }else{
            this.rear.next=node;
            this.rear=node;
        }
        this.usedSize++;
    }
    // 返回元素个数
    public int size(){
        return this.usedSize;
    }
}
