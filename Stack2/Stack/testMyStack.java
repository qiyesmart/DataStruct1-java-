package Stack;

import java.util.Stack;

/**
 * Author:QiyeSmart
 * Created:2019/7/5
 */
//两个栈实现队列
class testMyStack {
    //stack1入元素
    Stack<Integer> stack1;
    //stack2出元素
    Stack<Integer> stack2;
    public testMyStack(){
        stack1=new Stack<Integer>();
        stack2=new Stack<Integer>();
    }
    public void push(int x){
        stack1.push(x);
    }
    public int pop(){
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        int tmp=0;
        if(!stack2.empty()){
            tmp=stack2.pop();
        }
        return tmp;
    }
    public int peek(){
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        int tmp=0;
        if(!stack2.empty()){
            tmp=stack2.peek();
        }
        return tmp;
    }
    public boolean empty(){
        return stack1.empty()&&stack2.empty();
    }
}
