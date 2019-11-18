public class Teststaticblock {
    static {
        System.out.println("static");
    }
    {
        System.out.println("block");
    }
    public Teststaticblock(){
        System.out.println("A");
    }

    public static void main(String[] args) {
        Teststaticblock teststaticblock = new Teststaticblock();
    }

}
