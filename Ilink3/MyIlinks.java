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
        //练习题将其属性改为public
        //private Node next;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
        public int getData() {
            return data;
        }
        public Node getNext() {
            return next;
        }
    }

    private Node head;

    public MyIlinks() {
        this.head = null;
    }

    public Node getHead() {
        return head;
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
    //反转一个单链表
    public Node reverseList() {
        Node reverseHead = null;//反转后新的头结点
        Node cur = this.head;//cur代表当前需要反转的节点
        Node prev = null;//cur的前驱--》前驱信息
        while(cur != null) {
            Node curNext = cur.next;
            if(curNext == null) {
                reverseHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return reverseHead;
    }
    //打印指定节点开始的数据
    public void show(Node newHead) {
        Node cur = newHead;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //找到单链表的中间节点
    public Node middleNode() {
        Node cur = this.head;
        int len = getLength()/2;
        for (int i = 0; i < len; i++) {
            cur = cur.next;
        }
        return cur;
    }
    //找到倒数第k个结点
    public Node findKthToTail(int k) {
        if(this.head == null || k <= 0){// k > getLength()
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(k-1 > 0) {
            if(fast.next != null) {
                fast = fast.next;
                k--;
            }else {
                System.out.println("没有这个节点");
                return null;
            }
        }
        //一起走
      while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
      }
      return slow;
    }
    //以给定值x为基准将链表分割成两部分
    public Node partition(int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node pHead = this.head;
        while(pHead != null) {
            Node pHeadNext = pHead.next;
            pHead.next = null;
            if(pHead.data < x) {
                if(beforeStart == null) {
                    beforeStart = pHead;
                    beforeEnd = beforeStart;
                }else {
                    beforeEnd.next = pHead;
                    beforeEnd = pHead;
                }
            }else {
                if(afterStart == null) {
                    afterStart = pHead;
                    afterEnd = afterStart;
                }else {
                    afterEnd.next = pHead;
                    afterEnd = afterEnd.next;
                }
            }
            pHead = pHeadNext;
        }
        if(beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;//单链表进行拼接
        return beforeStart;
    }

    //单链表是否有环
    //创造环
    public void createLoop() {
        Node cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }

    public boolean hasCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                //return true;
                break;
            }
        }
        if(fast != null && fast.next != null) {
            return true;
        }
        return false;
    }
    //链表的环的入口点
    public Node entranceCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        //没有环  返回null
        if(fast == null || fast.next == null){
            return null;
        }
        //寻找头结点
        slow = this.head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public Node deletcNode() {
        //虚拟结点
        Node node = new Node(-1);
        Node cur = this.head;
        Node tmphead = node;
        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
                tmphead.next = cur;
            } else {
                //确定不为重复的节点，串
                tmphead.next = cur;
                tmphead = cur;
                cur = cur.next;
            }
        }
        return  node.next;
    }
    //链表的回文结构
    public boolean checkPalindrome() {
         Node fast=this.head;
         Node  slow=this.head;
         while(fast!=null&&fast.next!=null){
             fast=fast.next.next;
             slow=slow.next;
         }
        //slow指向的位置就是中间节点
        //翻转链表后半部分
        Node p = slow.next;
        Node pNext = p.next;
        while(p != null) {
            p.next = slow;
            slow = p;
            p = pNext;
            if(p != null) {
                pNext = p.next;
            }
        }
        //
        while(this.head != slow) {
            if(this.head.data != slow.data){
                return false;
            }

            if(this.head.next == slow) {
                return true;
            }

            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}