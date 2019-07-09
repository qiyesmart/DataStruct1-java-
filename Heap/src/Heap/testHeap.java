package Heap;

import java.util.Arrays;

/**
 * Author:QiyeSmart
 * Created:2019/7/9
 */
public class testHeap implements  IHeap {
    private int[]  elem;
    private int usedSize;
    private  static   final int   DEFAULT_SIZE=10;
    public testHeap(){
        this.elem=new int[DEFAULT_SIZE];
        this.usedSize=0;
    }
    //从每颗子树的根节点开始调整 调整的长度为len
    public void AdjustDown(int root,int len){
        int parent = root;
        int child = 2*parent+1;
        while (child < len) {
            if( child+1 < len && elem[child] < elem[child+1]){
                ++child;
            }
            //child下标存放的是左右孩子的最大值
            if(elem[child] > elem[parent]){
                //交换
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }
    //初始化建立大根堆
    public void initHeap(int[] array){
        for(int i=0;i<array.length;i++){
            this.elem[i]=array[i];
            this.usedSize++;
        }
        for(int i=(array.length-1-1)/2;i>=0;i--){
            AdjustDown(i,this.usedSize);
        }
    }
    //向上调整，从孩子节点开始调整
    public void AdjustUp(int child){
        int parent=(child-1)/2;
        while(child>0){
            if(elem[child]>elem[parent]){
                //交换
                int tmp=elem[child];
                elem[child]=elem[parent];
                elem[parent]=tmp;
                child=parent;
                parent=(child-1)/2;
            }else{
                break;
            }
        }
    }
    public boolean isFull(){
        return this.usedSize==this.elem.length;
    }
    // 插入 item 到堆中
    public void pushHeap(int item){
        if(isFull()){
            this.elem=Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[this.usedSize]=item;
        this.usedSize++;
        AdjustUp(this.usedSize-1);
    }

    // 返回堆顶元素，删除数据元素
    public boolean isEmpty(){
        return this.usedSize==0;
    }
    public int popHeap() {
        if(isEmpty()){
            throw new UnsupportedOperationException("堆为空");
        }
        int oldData = elem[0];
        int tmp = elem[0];
        elem[0] = elem[this.usedSize-1];
        elem[this.usedSize-1] = tmp;
        this.usedSize--;
        AdjustDown(0,this.usedSize);
        return oldData;
    }
    // 返回堆顶元素，不删除数据元素
    public int getHeapTop(){
        if(isEmpty()){
            throw new UnsupportedOperationException("堆为空");
        }
        return elem[0];
    }
    //堆排序
    //时间复杂度:  N*longN   空间复杂度：1   不稳定
    public void HeapSort(){
        //未初始化之前先建立大根堆
        /* for (int i = (array.length-1-1)/2; i >= 0 ; i--) {
                    AdjustDown(i,this.usedSize);
                }*/
        int end = this.usedSize-1;
        while (end > 0) {
            int tmp = elem[0];
            elem[0] = elem[end];
            elem[end] = tmp;
            AdjustDown(0,end);
            end--;
        }

    }
    //打印堆
    public void show(){
        for(int i=0;i<this.usedSize;i++){
            System.out.print(elem[i]+" ");
        }
        System.out.println();
    }
}
