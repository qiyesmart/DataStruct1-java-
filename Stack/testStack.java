package Stack;

/**
 * Author:QiyeSmart
 * Created:2019/5/22
 */
public class testStack {
    public static void main(String[] args) {
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

}
