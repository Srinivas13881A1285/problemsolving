class A1 {}
class B1 extends A1{}

public class ComingThru {
    static String s="-";

    public static void main(String[] args) {
        A1[] aa = new A1[2];
        B1[] ba= new B1[2];
        sifter(aa);
        sifter(ba);
        sifter(7);
        System.out.println("s = " + s);;
    }
    
    static void sifter(A1[]... a2){
        s+="1";
    }
    
    static void sifter(B1[]... b1){
        s+="2";
    }

    static void sifter(B1[] b1){
        s+="3";
    }
    
    static void sifter(Object o){
        s+="4";
    }
}
