package Ilink;
/**
 * Author:QiyeSmart
 * Created:2019/5/7
 */
public class MyIlinks implements  Ilinks{
    class Node{
        private int data;
        private Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head;
    public MyIlinks(){
        this.head=null;
    }
    //头插法
    public void addFirst(int data){
        Node node=new Node(data);
        if(head==null){
            this.head=node;
        }else{
            node.next=this.head;
            this.head=node;
        }
    }
    //尾插法
    public void addLast(int data){
        Node node=new Node(data);
        Node cur=this.head;
        if(cur==null){
            this.head=node;
        }else{
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    //public boolean addIndex(int index,int data){
    //    Node node=new Node(data);

   // }
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

    }
    //删除所有值为key的节点
    //void removeAllKey(int key);
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
    //void clear();
}
