package Ilink;

/**
 * Author:QiyeSmart
 * Created:2019/5/7
 */
public class test {
    public static void main(String[] args){
        MyIlinks  link=new MyIlinks();
       /* link.addFirst(1);
        link.addFirst(2);
        link.addFirst(3);
        link.addFirst(4);
        link.display();*/
        link.addLast(1);
        link.addLast(2);
        link.addLast(3);
        link.addLast(4);
        link.addLast(5);
        link.display();
        Object c=link.contains(8);
        System.out.println(c);
        link.remove(1);
        link.display();
        Object d=link.getLength();
        System.out.println(d);
    }
}
