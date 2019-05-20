package Ilink;

/**
 * Author:QiyeSmart
 * Created:2019/5/7
 */
public class test {
    //测试无头单链表
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
    //带头循环单链表
    public static void code3(){
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


    public static void main(String[] args){
       MyIlinks   link=new  MyIlinks();
       link.addLast(1);
        link.addLast(2);
        link.addLast(3);
        link.addLast(2);
        link.addLast(1);
        link.display();
        /*
        //MyIlinks.Node str=link.reverseList();
        //link.show(str);
        MyIlinks.Node  str1=link.middleNode();
        System.out.println( str1.getData());
        MyIlinks.Node  str2=link.findKthToTail(3);
        link.show(str2);
        MyIlinks.Node  str3=link.partition(4);
        link.show(str3);
        link.createLoop();
        System.out.println(link.hasCycle());
        MyIlinks.Node  str4=link.entranceCycle();
        System.out.println(str4.getData());*/
        //link.deletcNode();
        //link.display();
       boolean str= link.checkPalindrome();
        System.out.println(str);

    }
}
