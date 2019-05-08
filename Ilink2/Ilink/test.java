package Ilink;

/**
 * Author:QiyeSmart
 * Created:2019/5/7
 */
public class test {
    public static void code1(){
        MyIlinks  link=new MyIlinks();
       /* link.addFirst(1);
        link.addFirst(2);
        link.addFirst(3);
        link.addFirst(4);
        link.display();*/
        link.addLast(1);
        link.addLast(2);
        link.addLast(3);
        link.addLast(2);
        link.addLast(5);
        link.display();
        Object c=link.contains(3);
        System.out.println(c);
        //link.remove(1);
        link.display();
        Object d=link.getLength();
        System.out.println(d);
        link.removeAllKey(2);
        link.display();
        link.clear();
        link.display();
    }
    public static void main(String[] args){
        MyICLink ls=new MyICLink();
        ls.addFirst(1);
        ls.addFirst(2);
        ls.addFirst(3);
        ls.display();
        ls.addLast(4);
        ls.addLast(5);
        ls.display();
        ls.addindex(1,6);
        ls.display();
        ls.addLast(1);
        ls.addFirst(1);
        ls.display();
        Object a=ls.contains(3);
        System.out.println(a);
        ls.removeAllKey(1);
        ls.display();
        ls.clear();
        ls.display();

    }
}
