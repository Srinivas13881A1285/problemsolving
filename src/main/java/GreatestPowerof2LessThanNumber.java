public class GreatestPowerof2LessThanNumber {
    public static void main(String[] args) {
        int n = 25;
        double power = Math.log(n)/Math.log(2);
        int res = (int) Math.pow(2,(int)power);
        System.out.println("res = " + res);
    }
}
