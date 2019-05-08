package Ilink;
/**
 * Author:QiyeSmart
 * Created:2019/5/7
 */
/*
无头单链表
 */
public class MyIlinks implements  Ilinks {
    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public MyIlinks() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if (head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        if (cur == null) {
            this.head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    private void checkIndex(int index){
        if(index<0||index>getLength()){
            throw new  UnsupportedOperationException("位置不合法");
        }
    }
    private Node searchIndex(int index){
        checkIndex(index);
        Node cur=this.head;
        int count=0;
        while(count<index-1){
            cur=cur.next;
            count++;
        }
        return cur;
    }
    public boolean addIndex(int index,int data){
        if(index==0){
            addFirst(data);
            return true;
        }
        Node node = new Node(data);
        Node cur=searchIndex(index);
        node.next=cur.next;
        cur.next=node;
        return true;


    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        if(this.head==null) {
            return false;
        }
        Node cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点3.3 链表面试题

    /*
    未考虑遍历为空的条件
    public  int remove(int key){
        if(this.head==null) {
            return -1;
        }
        Node del;
        Node cur;
        if(this.head.data==key){
            del=this.head;
            this.head=this.head.next;
            return del.data;
        }else{
            cur=this.head;
            while(cur.next.data!=key){
                cur=cur.next;
            }
            del=cur.next;
            cur.next=del.next;
            return del.data;
        }

    }*/
    private Node searchPrev(int key) {
        Node cur = this.head;
        while (cur.next != null) {
            if(cur.next.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    public  int remove(int key) {
        if(this.head==null){
            throw  new UnsupportedOperationException("单链表为空");
        }
        Node del;
        //删除头结点
        if(this.head.data==key){
            del=this.head;
            this.head=this.head.next;
            return del.data;
        }
        Node prev=searchPrev(key);
        if(prev==null){
            throw new UnsupportedOperationException("无前驱");
        }
            del = prev.next;
            prev.next = del.next;
            return del.data;

    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        if(this.head==null){
            return;
        }
        Node prev=this.head;
        Node cur=this.head.next;
        while(cur!=null){
            if(cur.data==key){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }
        if(this.head.data==key){
              this.head=this.head.next;
        }
    }
    //得到单链表的长度
    public int getLength(){
        int count=0;
        Node cur=this.head;
        if(cur==null){
            return 0;
        }else {
            while(cur!=null){
                count++;
                cur=cur.next;
            }
            return count;
        }
    }
    public void display(){
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){
        while(this.head.next!=null){
            Node del=this.head.next;
            this.head.next=del.next;
        }
        this.head=null;
    }
}
