package Fequence;
import java.util.Arrays;


/**
 * Author:QiyeSmart
 * Created:2019/5/7
 */
public class MySequence implements sequence {
    private Object[] number;
    private int usedSize;
    private static final  int MAX_SIZE=10;
    //构造函数
    public MySequence(){
        this.number=new Object[MAX_SIZE];
        this.usedSize=0;
    }
    //顺序表是否为满
    private boolean isFull(){
        if(this.usedSize==this.number.length){
            return true;
        }
        return false;
    }
    //顺序表是否为空
    private boolean isEmpty(){
        if(this.usedSize==0){
            return true;
        }
        return false;
    }
    //在pos位置插入val
    public boolean add(int pos,Object data){
        if(pos<0||pos>this.usedSize){
            return false;
        }
        //2、判断是否为满。
        if(isFull()){
            //2倍扩容
            //System.arraycopy();
            this.number = Arrays.copyOf(this.number,
                    2*this.number.length);
        }
        for(int i=this.usedSize-1;i>=pos;i--){
            this.number[i+1]=this.number[i];
        }
        this.number[pos]=data;
        this.usedSize++;
        return true;
    }
    //查找关键字key 找到返回key的下标，没有返回-1;
    public int search(Object key){
        if(isEmpty()){
            return -1;
        }
        for(int i=0;i<this.usedSize;i++){
            if(this.number[i].equals(key)){
                return i;
            }
        }
        return -1;
    }
    //查找是否包含关键字key是否在顺序表当中(这个和search有点冲突)
    public boolean contains(Object key){
        if(isEmpty()){
            return false;
        }
        for(int i=0;i<this.usedSize;i++){
            if(this.number[i].equals(key)){
                return true;
            }
        }
        return false;
    }
    //得到pos位置的值
    public Object getPos(int pos){
        if(pos<0||pos>this.usedSize){
            return false;
        }
        return this.number[pos];
    }
    //删除第一次出现的关键字key
    public Object remove(Object key){
        int index = search(key);
        if(index==-1){
            return null;
        }
        Object data = this.number[index];
        int i;
      for( i=index;i<this.usedSize-1;i++){
          this.number[i]=this.number[i+1];
      }
      this.usedSize--;
      this.number[i]=null;
      return data;
    }
    //得到顺序表的长度
   public  int size(){
        return this.usedSize;
   }
    //打印顺序表
    public void display(){
       for(int i=0;i<this.usedSize;i++){
           System.out.println(this.number[i]+" ");
       }
    }
    //清空顺序表以防内存泄漏
    public void clear(){
        for (int i = 0; i < this.usedSize; i++) {
            this.number[i] = null;
        }
    }
}