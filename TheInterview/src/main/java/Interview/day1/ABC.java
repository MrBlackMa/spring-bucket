package Interview.day1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.WeakHashMap;

/**
 * @Auther: smile malixi
 * @Date: 2021/3/2 - 10:44
 * @Description: Interview.day1
 * @version: 1.0
 */
public class ABC{

 static class A{

     public void a1(){
         System.out.println("a1");
     }

     public A(){
         a1();
     }

     public static void main(String[] args) {
//           B b=new B();
//           b.a1();
//           int i = 0;
//         System.out.println(i);
//           try{
//               ++i;
//               System.out.println("wo");
//               return ;
//           }finally {
//               System.out.println("ni");
//               System.out.println(i);
//           }
         int[] a = null;
         a[0]=1;
         System.out.println(a[0]);

         LinkedList a1=new LinkedList();

         HashSet hs=new HashSet();

         final  int a3=5;

     }

 }

 static class B extends  A{
     public void a1(){
         System.out.println("b1");
     }
 }

}
