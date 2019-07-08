package Stack;

/**
 * Author:QiyeSmart
 * Created:2019/7/5
 */

//最小栈
class minStack {
    int[] stack=new int[10];
    int i=0;

    //最小栈
    int[] minstack=new int[10];
    int j=0;

    public void push(int x){
        stack[i++]=x;
        if(j==0){
            minstack[j++]=x;
        }else{
            if(x<minstack[j-1]){
             minstack[j++]=x;
            }
        }
    }

    public void pop(){
        if(i!=0){
            int data=stack[--i];
            if(data==minstack[j-1]){
                --j;
            }
        }
    }

    public int top(){
        if(i==0){
            throw new UnsupportedOperationException("栈为空");
        }
       return stack[i-1];
    }

    public int getMin(){
        if(j==0){
            throw new UnsupportedOperationException("栈为空");
        }
        return minstack[j-1];
    }


}
