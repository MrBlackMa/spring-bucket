package Interview.day1;

import java.util.ArrayList;
import java.util.List;

class Test {
    private float f=1.0f;
    int m=12;
    static int n=1;
    public static void main(String args[]){
        Test t=new Test();
        List list=new ArrayList();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(6);
        list.add(0,4);
        System.out.println(list.toString());
        list.remove(1);
        System.out.println(list.toString());

        Integer a = 1;
        Integer b = 1;
        Integer c = 500;
        Integer d = 500;
        System.out.print(a == b);
        System.out.print(c == d);


    }
}