package algorithms;

public class TestA {
    public static void main(String[] args) {
        System.out.println(fun(4,3));
    }

    static int fun(int x,int y){
        if(x == 0)
            return y;
        return fun(x-1,x+y);
    }
}
