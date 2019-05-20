package Ilink;

/**
 * Author:QiyeSmart
 * Created:2019/5/20
 */
public class testLianxi {
    //链表相交第一个结点
    public static void createCut( MyIlinks.Node headA,
                                  MyIlinks.Node headB){
        // headA.getNext().getNext() = headB.getNext().getNext();
        headA.next.next = headB.next.next.next;
    }
    public static MyIlinks.Node getIntersectionNode(
            MyIlinks.Node headA, MyIlinks.Node headB) {

        MyIlinks.Node pL = headA;

        MyIlinks.Node pS = headB;

        int lenA = 0;
        while(pL != null){
            lenA++;
            pL = pL.getNext();
        }
        int lenB = 0;
        while(pS != null){
            lenB++;
            pS = pS.getNext();
        }
        //
        pL = headA;
        pS = headB;
        //
        int len = lenA-lenB;
        if(len < 0) {
            pL = headB;//B单链表是长的
            pS = headA;
            len = lenB-lenA;
        }
        //最长的单链表永远是pL 并且差值len是一个正数

        for (int i = 0; i < len; i++) {
            pL = pL.getNext();
        }
        //pL 和pS 在同一个起跑线上

        while(pL != null && pS != null && pL != pS) {
            pL = pL.getNext();
            pS = pS.getNext();
        }

        if(pL == pS && pL != null && pS != null) {
            return pL;
        }
        return null;
    }
    //合并有序链表
    public static MyIlinks.Node mergeTwoLists(
            MyIlinks.Node headA, MyIlinks.Node headB) {
        MyIlinks mySingleList1 = new MyIlinks();
        MyIlinks.Node newHead =
                mySingleList1.new Node(-1);//虚拟节点

        MyIlinks.Node tmpHead = newHead;
        //谁小串谁
        while(headA != null &&  headB != null) {
            if(headA.getData() >= headB.getData()){
                tmpHead.next = headB;
                tmpHead = tmpHead.next;
                headB = headB.next;
            }else {
                tmpHead.next = headA;
                tmpHead = tmpHead.next;
                headA = headA.next;
            }
        }

        if(headA != null){
            tmpHead.next = headA;
        }

        if(headB != null) {
            tmpHead.next = headB;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ////链表相交第一个结点
        MyIlinks  link1=new MyIlinks();
        link1.addLast(1);
        link1.addLast(2);
        link1.addLast(3);
        link1.addLast(4);
        link1.addLast(5);
        MyIlinks  link2=new MyIlinks();
        link2.addLast(1);
        link2.addLast(2);
        link2.addLast(8);
        link2.addLast(9);
        link2.addLast(10);
        ////链表相交第一个结点
        /*
        createCut(link1.getHead(),link2.getHead());
        link1.display();
        link2.display();
        MyIlinks.Node s=getIntersectionNode(link1.getHead(),link2.getHead());
        System.out.println(s.getData());
        */
        // //合并有序链表
        MyIlinks.Node sd=mergeTwoLists(link1.getHead(),link2.getHead());
        link1.show(sd);
    }

}
