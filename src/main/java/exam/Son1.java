package exam;
class Man1{
    Man1(){
        System.out.println("Man ");
    }
}

class Father1 extends Man1{
    Father1(String type){
        System.out.println(type);
    }
}
public class Son1 extends Father1{
    Son1(){
        super("Father ");
        new Father1("Son ");
    }

    public static void main(String[] args) {
        new Son1();
    }
}
