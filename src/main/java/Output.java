class computeValue extends Exception{
    int detail;
    computeValue(int a){
        detail = a;
    }

    public String toString(){
        return "detail";
    }

}

public class Output {

    static void compute(int a)throws computeValue{
        throw new computeValue(a);
    }
    public static void main(String[] args) {
        try{
            compute(3);
        }catch (computeValue e){
            System.out.println("Exception");
        }
    }
}
