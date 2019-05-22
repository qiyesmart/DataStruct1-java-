package Ilink;

/**
 * Author:QiyeSmart
 * Created:2019/5/22
 */
public class MyIDoubleLinked implements IDoubleLinked {
    class Node{
        private int data;
        private Node next;
        private Node prev;
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }

    }
    private Node head;
    private Node last;
    public MyIDoubleLinked(){
        this.head=null;
        this.last=null;
    }
    //头插法
    public void addFirst(int data){
        Node node=new Node(data);
       if(this.head==null) {
           this.head=node;
           this.last=node;
       }else{
           node.next=this.head;
           this.head.prev=node;
           this.head=node;
       }
    }
    //尾插法
    public void addLast(int data){
        Node node=new Node(data);
        if(this.head==null){
            this.head=node;
            this.last=node;
        }else{
            this.last.next=node;
            node.prev=this.last;
            last=node;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    private Node searchIndex(int index){
        if(index<0||index>getLength()){
            throw new  UnsupportedOperationException("位置不合法");
        }
        int count=0;
        Node cur=this.head;
        while(count!=index){
            cur=cur.next;
            count++;
        }
        return  cur;
    }
    public boolean addindex(int index,int data){
        if(index==0){
            addFirst(data);
            return true;
        }
        if(index==getLength()){
            addFirst(data);
            return true;
        }
       Node cur= searchIndex(index);
       Node node=new Node(data);
       node.next=cur;
       cur.prev.next=node;
       node.prev=cur.prev;
       cur.prev=node;
       return true;

    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public int remove(int key){
        Node cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                if(cur==this.head){
                    this.head=this.head.next;
                    this.head.prev=null;
                }else{
                    cur.prev.next=cur.next;
                    if(cur.next!=null){
                        cur.next.prev=cur.prev;
                    }else{
                        this.last=cur.prev;
                    }
                }
                return cur.data;
            }
            cur=cur.next;
        }
        return -1;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                if(cur==this.head){
                    this.head=this.head.next;
                    this.head.prev=null;
                }else{
                    cur.prev.next=cur.next;
                    if(cur.next!=null){
                        cur.next.prev=cur.prev;
                    }else{
                        this.last=cur.prev;
                    }
                }
            }
            cur=cur.next;
        }
    }
    //得到单链表的长度
    public int getLength(){
        int count=0;
        Node cur=this.head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    public void display(){
        //打印和前驱没有没有关系
        Node cur=this.head;
        while(cur!=null){
            System.out.println(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    public void clear(){
     while(this.head!=null){
         Node cur=this.head.next;
         this.head.next=null;
         this.head.prev=null;
         this.head=cur;
     }
     this.last=null;
    }
}
