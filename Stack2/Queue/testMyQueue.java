package Queue;

/**
 * Author:QiyeSmart
 * Created:2019/7/5
 */
//两个队列实现栈
public class testMyQueue {
    private MyQueue myQueue1;
    private MyQueue myQueue2;
    private int usedsize;
    public testMyQueue(){
        myQueue1=new MyQueue();
        myQueue2=new MyQueue();
        this.usedsize=0;
    }
    public void push(int x){
        if(!myQueue1.empty()){
            myQueue1.add(x);
        }else if(!myQueue2.empty()){
            myQueue2.add(x);
        }else{
            myQueue1.add(x);
        }
        this.usedsize++;
    }
    public int pop(){
        int data=0;
        if(!myQueue1.empty()){
            for(int i=0;i<this.usedsize-1;i++){
                myQueue2.add(myQueue1.poll());
            }
            data=myQueue1.poll();
        }else{
            for(int i=0;i<this.usedsize-1;i++){
                myQueue1.add(myQueue2.poll());
            }
            data=myQueue2.poll();
        }
        this.usedsize--;
        return data;
    }
    public int top(){
        int data=0;
        if(!myQueue1.empty()){
            for(int i=0;i<this.usedsize;i++){
                data=myQueue1.poll();
                myQueue2.add(data);
            }
        }else{
            for(int i=0;i<this.usedsize;i++){
                data=myQueue2.poll();
                myQueue1.add(data);
            }
        }
        return data;
    }
    public boolean empty(){
        return this.usedsize==0;
    }
}
