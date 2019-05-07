package Fequence;


/**
 * Author:QiyeSmart
 * Created:2019/5/7
 */
public class testMySequence {
    public static void main(String args[]){
        MySequence se=new MySequence();
        for(int i=0;i<20;i++){
            se.add(i,i);
        }
        //se.display();
        Object str=se.contains(22);
        System.out.println(str);
        //se.remove(10);
        //se.display();
    }
}
