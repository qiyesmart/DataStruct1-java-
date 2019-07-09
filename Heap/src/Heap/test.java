package Heap;

/**
 * Author:QiyeSmart
 * Created:2019/7/9
 */
public class test {
    public static void main(String[] args) {
        testHeap testheap=new testHeap();
        int[]   array={1,2,3,4,5,6,7,8,9,10};
        testheap.initHeap(array);
        testheap.show();
        testheap.pushHeap(11);
        testheap.show();
        testheap.popHeap();
        testheap.show();
        testheap.HeapSort();
        testheap.show();
    }
}
