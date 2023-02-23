package Interview.day1;

public class Bground extends Thread{

    @Override
    public  void run() {
        for(int i=0;i<100;i++){
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
//        Bground a=new Bground();
//        a.start();
        double d1=-0.5;
        System.out.println("Ceil d1="+Math.ceil(d1));
        System.out.println("floor d1="+Math.floor(d1));


    }

}