import java.util.Arrays;
import java.util.Stack;

/**
 * Author:QiyeSmart
 * Created:2019/7/5
 */
public class testSort {
    //直接插入排序
    //时间复杂度 n^2  空间复杂度 1  稳定
    //排序发生跳跃式的交换则次算法不稳定
    //越有序越快
    public static void insertSort(int[] array){
        long start=System.currentTimeMillis();
        int j=0;
        for(int i=1;i<array.length;i++){
            int tmp=array[i];
            for( j=i-1;j>=0;j--){
                if(array[j]>tmp){
                    array[j+1]=array[j];
                }else{
                    //array[j+1]=tmp;
                    break;
                }
            }
            array[j+1]=tmp;
        }
        long end=System.currentTimeMillis();
        System.out.println(start-end);
    }


    //shell排序
    //时间复杂度 n^1.3~  n^2 空间复杂度 1  不稳定
    public static void shell(int[] array,int gap){
        for(int i=gap;i<array.length;i++){
            int tmp=array[i];
            int j=0;
            for( j=i-gap;j>=0;j-=gap){
                if(array[j]>tmp){
                    array[j+gap]=array[j];
                }else{
                    break;
                }
            }
            array[j+gap]=tmp;
        }
    }
    public static void shellSort(int[] array){
        int[] drr={5,3,1};
        for(int i=0;i<drr.length;i++){
            shell(array,drr[i]);
        }
    }


    //选择排序
    //时间复杂度 n^2 空间复杂度 1  不稳定
    public static void selectSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[i]){
                    int tmp=array[j];
                    array[j]=array[i];
                    array[i]=tmp;
                }
            }
        }
    }


    //冒泡排序
    //时间复杂度 n^2（优化后为n）空间复杂度 1  稳定
    public static void bubbleSort1(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
    }
    //优化
    public static void bubbleSort2(int[] array){
        boolean swap=false;
        for(int i=0;i<array.length-1;i++){
            swap=false;
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    swap=true;
                }
            }
            if(!swap){
                break;
            }
        }
    }


    //快速排序
    //1.递归
    //时间复杂度 最好： N*logN 最坏：N^2 空间复杂度 最好：logN 最坏：N 不稳定
    //三数取中法
    public static void swap(int[]  array,int low,int high){
        int tmp=array[low];
        array[low]=array[high];
        array[high]=tmp;
    }
    public   static void  middleOfThree(int[]  array,int low,int high){
        int mid=(low+high)/2;
        if(array[mid]>array[low]) {
            swap(array, mid, low);
        }
        //array[mid]<=array[low]
        if(array[mid]>array[high]){
            swap(array,mid,high);
        }
        //array[mid]<=array[high]
        if(array[low]>array[high]){
            swap(array,low,high);
        }
        //array[low]<=array[high]
        //array[mid]<=array[low]<=array[high]
    }
    //（优化算法）
    public static void insertSort2(int[] array,int start,int end){
        int j=0;
        for(int i=start+1;i<=end;i++){
            int tmp=array[i];
            for( j=i-1;j>=start;j--){
                if(array[j]>tmp){
                    array[j+1]=array[j];
                }else{
                    //array[j+1]=tmp;
                    break;
                }
            }
            array[j+1]=tmp;
        }
    }
    public static int partion(int[] array,int low,int high) {
        int tmp =  array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            if(low >= high) {
                break;
            }else {
                array[low] = array[high];
            }
            while (low < high && array[low] <= tmp) {
                low++;
            }
            if(low >= high) {
                break;
            }else {
                array[high] = array[low];
            }
        }
        array[low] = tmp;
        return low;
    }
    public static void quick(int[]   array,int start,int end){
        //如果元素个股小于等于16，直接插入排序
        if(end-start+1<=16){
            insertSort2(array,start,end);
            return;
        }
        //找基准之前先三数取中，防止时间复杂度为N^2
        middleOfThree(array,start,end);
        int par=partion(array,start,end);
        //递归左边
        if(par>start+1){
            quick(array,start,par-1);
        }
        //递归右边
        if(par<end-1){
            quick(array,par+1,end);
        }
    }
    public static  void  quickSort(int[]  array){
        quick(array,0,array.length-1);
    }
    //2.非递归
    public static  void  quickSort2(int[]  array){
        Stack<Integer> stack=new Stack<>();
        int low=0;
        int high=array.length-1;
        int par=partion(array,low,high);
        if(par>low+1){
            stack.push(low);
            stack.push(par-1);
        }
        if(par<high-1){
            stack.push(par+1);
            stack.push(high);
        }
        while(!stack.empty()){
            high=stack.pop();
            low=stack.pop();
            par=partion(array,low,high);
            if(par>low+1){
                stack.push(low);
                stack.push(par-1);
            }
            if(par<high-1){
                stack.push(par+1);
                stack.push(high);
            }
        }
    }

    //归并排序
    //递归
    //时间复杂度  N*logN  空间复杂度 N   稳定
    public static void merge(int[] array,int start,
                             int mid,int end) {
        int[] tmpArray = new int[array.length];
        int tmpIndex = start;
        int i = start;
        int s2 = mid+1;
        //当有两个归并段的时候
        while (start <= mid && s2 <= end) {
            if(array[start] <= array[s2]) {
                tmpArray[tmpIndex++] = array[start++];
            }else {
                tmpArray[tmpIndex++] = array[s2++];
            }
        }
        //第一个归并段有数据
        while (start <= mid) {
            tmpArray[tmpIndex++] = array[start++];
        }
        //第二个归并段有数据
        while (s2 <= end) {
            tmpArray[tmpIndex++] = array[s2++];
        }
        //把排好序的数据从tmpArray里面拷贝到array
        while (i <= end) {
            array[i] = tmpArray[i++];
        }
    }
    public static void mergeSort(int[] array,int start,int end){
        if(start>=end){
            return;
        }
        int mid=(start+end)/2;
        mergeSort(array,start,mid);
        mergeSort(array,mid+1,end);
        merge(array,start,mid,end);
    }
    //非递归
    public  static void   merge2(int[]  array,int gap){
        int[]   tmpArray=new int[array.length];
        int i=0;//tmpArray的下标
        int start1=0;
        int end1=start1+gap-1;
        int start2=end1+1;
        int end2=start2+gap-1<=array.length-1?start2+gap-1:array.length-1;
        //保证有两个归并段
        while(start2<array.length){
            while(start1<=end1&&start2<=end2){
                //比较
                if(array[start1]<=array[start2]){
                    tmpArray[i++]=array[start1++];
                }else{
                    tmpArray[i++]=array[start2++];
                }
            }
            //第一个归并段有数据
            while (start1 <= end1) {
                tmpArray[i++] = array[start1++];
            }
            //第二个归并段有数据
            while (start2 <= end2) {
                tmpArray[i++] = array[start2++];
            }
            //证明一次二路归并已经完成
             start1=end2+1;
             end1=start1+gap-1;
             start2=end1+1;
             end2=start2+gap-1<=array.length-1?start2+gap-1:array.length-1;
            }
         while(start1<array.length){
             tmpArray[i++] = array[start1++];
         }
        //把排好序的数据从tmpArray里面拷贝到array
        for (int j=0;j<tmpArray.length;j++) {
            array[j] = tmpArray[j];
        }
    }
    public static void mergeSort2(int[] array){
        for(int i=1;i<array.length;i*=2){
            merge2(array,i);
        }
    }

    public static void main(String[] args){
        int[]   array={3,6,7,4,5,9,2,1};
        System.out.println(Arrays.toString(array));
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //bubbleSort1(array);
        //quickSort2(array);
        //mergeSort(array,0,array.length-1);
        mergeSort2(array);
        System.out.println(Arrays.toString(array));
    }
}
