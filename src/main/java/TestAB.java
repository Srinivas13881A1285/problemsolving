import java.io.IOException;

public class TestAB {
    public static void main(String[] args) {

        try {
            B b = new B();
            System.out.println(b.returnSomeValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class A{
    protected Object returnSomeValue() throws IOException{
        return "someValue";
    }
}

class B extends A{
    /*public String returnSomeValue() throws Exception{
        return "someValueB";
    }*/
}
