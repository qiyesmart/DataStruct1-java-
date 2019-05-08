package Ilink;

/**
 * Author:QiyeSmart
 * Created:2019/5/7
 */
public interface ICLink {
        //头插法
        void addFirst(int data);
        //尾插法
        void addLast(int data);
        //任意位置插入,第一个数据节点为0号下标
        boolean addindex(int index,int data);
        //查找是否包含关键字key是否在  boolean contains(int key)单链表当中
      ;
        //删除第一次出现关键字为key的节点
        int remove(int key);
        //删除所有值为key的节点
        void removeAllKey(int key);
        //得到单链表的长度
        int getLength();
        void display();
        void clear();
}
