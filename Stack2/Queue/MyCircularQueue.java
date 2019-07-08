package Queue;

/**
 * Author:QiyeSmart
 * Created:2019/7/5
 */
//环形队列
class MyCircularQueue {
    private int front;
    private int rear;
    private int usedSize;
    private int[] elem;
    public MyCircularQueue(int k){
        this.elem=new int[k];
        this.front=0;
        this.rear=0;
        this.usedSize=0;
    }
    public boolean enQueue(int value){
        if(isFull()) {
            return false;
        }
        this.elem[this.rear]=value;
        this.rear=(this.rear+1)%this.elem.length;
        this.usedSize++;
        return true;
    }
    public boolean deQueue(int value){
        if(isEmpty()){
            throw new UnsupportedOperationException("队列为空");
        }
        this.front=(this.front+1)%this.elem.length;
        this.usedSize--;
        return true;
    }
    public int Front(){
        if(isEmpty()){
            throw new UnsupportedOperationException("队列为空");
        }
        return this.elem[this.front];
    }
    public int Rear(){
        if(isEmpty()){
            throw new UnsupportedOperationException("队列为空");
        }
        int index=this.rear==0?this.elem.length-1:this.rear-1;
        return this.elem[index];
    }
    public boolean  isEmpty(){
        return this.rear==this.front;
    }
    public boolean  isFull(){
        if((this.rear+1)%this.elem.length==this.front){
            return true;
        }
        return false;
    }
}
