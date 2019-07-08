package Stack;

/**
 * Author:QiyeSmart
 * Created:2019/5/22
 */
public class MyIStack implements  ISatck {
    private int[]  elem;
    //当前可以存放数据元素的下标
    private int top;
    private int usedsize;

    public MyIStack(int size) {
        this.elem = new int[size];
        this.top = 0;
        this.usedsize=0;
    }

    // 将 item 压入栈中
    private boolean isFull(){
        return this.top==this.elem.length;
    }
    public void push(int item){
        if(isFull()){
            throw new UnsupportedOperationException("栈满了");
        }
        this.elem[this.top]=item;
        this.top++;
        this.usedsize++;
    }
    // 返回栈顶元素，并且出栈
    public int pop(){
        if(empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        this.top--;
        this.usedsize--;
        int oldData=this.elem[this.top];
        return oldData;
    }
    // 返回栈顶元素，但不出栈
    public int peek(){
        if(empty()){
            throw new UnsupportedOperationException("栈为空");
        }

        return this.elem[this.top-1];
    }
    // 判断这个栈是否为空栈
    public boolean empty(){
        return this.usedsize==0;
    }
    // 返回元素个数
    public int size(){
        return this.usedsize;
    }
}
