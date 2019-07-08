package Stack;
import java.util.Stack;
/**
 * Author:QiyeSmart
 * Created:2019/5/22
 */
public class testStack {
    public static void code1(){
        MyIStack stack=new MyIStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.empty());
    }
    //括号匹配问题
    public static boolean isValid(String s){
        char[] stack=new char[s.length()];
        int top=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack[top++]=s.charAt(i);
            }else{
                if(top==0){
                    System.out.println("右括号多");
                    return false;
                }else{
                    //得到栈顶元素进行比较
                    char ch=stack[top-1];
                    if(ch=='('||s.charAt(i)==')'||
                            ch=='['||s.charAt(i)==']'||
                            ch=='{'||s.charAt(i)=='}') {
                        //出栈
                        --top;
                    }else{
                        System.out.println("右括匹配次数出错");
                        return false;
                    }
                }
            }
        }
        if(top>0){
            System.out.println("左括号多");
            return false;
        }
        System.out.println("左右括号匹配成功 ");
        return true;
    }
    public static void code2(){
        minStack  minstack1=new minStack();
        minstack1.push(1);
        minstack1.push(2);
        minstack1.push(3);
        minstack1.push(4);
        minstack1.push(5);
        System.out.println(minstack1.getMin());
        System.out.println(minstack1.top());
    }
    public static void main(String[] args) {
        Stack<Integer>  stack3=new Stack<>();
        stack3.push(1);
        stack3.push(2);
        stack3.push(3);
        stack3.push(4);
        System.out.println(stack3.pop());
        System.out.println(stack3.peek());



    }

}
