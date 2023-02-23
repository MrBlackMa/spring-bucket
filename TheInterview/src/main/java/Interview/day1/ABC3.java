package Interview.day1;

class Base{
    public Base(String s){
        System.out.print("B");
    }
}
class Derived extends Base{
    public Derived (String s) {
        super("D");
    }
    public static void main(String[] args){
        new Derived("C");
    }
}