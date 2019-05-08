package Ilink;

/**
 * Author:QiyeSmart
 * Created:2019/5/7
 */
/*
带头循环单链表
 */
public class MyICLink implements ICLink{
    class Node {
        private int data;
        private Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
        //头结点
        public Node() {
            this.data = -1;
            this.next = null;
        }
    }

    private Node head;

    public MyICLink() {
        this.head = new Node();
        this.head.next = this.head;
    }
    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head.next;
        this.head.next = node;
    }
    //尾插法
    public void addLast(int data){
        Node cur=this.head;
        while(cur.next!=this.head){
            cur=cur.next;
        }
        Node node=new Node(data);
        node.next=cur.next;
        cur.next=node;

    }
    private void checkIndex(int index){
        if(index<0||index>getLength()){
            throw new  UnsupportedOperationException("位置不合法");
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addindex(int index,int data){
        checkIndex(index);
        Node cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        //cur就是index位置的前驱
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
        return true;

    }
    //查找是否包含关键字key是否在  boolean contains(int key)单链表当中
    public boolean contains(int key){
        Node cur = this.head.next;
        while(cur != this.head) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    private Node searchPrev(int key){
        Node cur=this.head;
        while (cur.next!=this.head){
            if(cur.next.data==key){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }
    public int remove(int key){
        Node prev=searchPrev(key);
        if(prev==null){
            throw  new UnsupportedOperationException("没有前驱");
        }
        Node del=prev.next;
        prev.next=del.next;
        return del.data;
    }
    //删除所有值为key的节点
    public  void removeAllKey(int key){
       Node prev=this.head;
        Node cur=this.head.next;
        while(cur!=this.head){
            if(cur.data==key){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }

    }
    //得到单链表的长度
    public int getLength(){
        int count=0;
        Node cur=this.head.next;
        while(cur!=this.head){
            cur=cur.next;
            count++;
        }
        return count;
    }
    public void display(){
        Node cur = this.head.next;
        while (cur != this.head) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){
        while(this.head.next!=this.head){
            Node del=this.head.next;
            this.head.next=del.next;
        }
    }
}
