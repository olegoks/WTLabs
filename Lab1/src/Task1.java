public class Task1 {

    private static double Calc(double x, double y){

       return  (1 + Math.pow(Math.sin(x + y), 2))
                / (2 + Math.abs(x - (2 * x / (1 + Math.pow(x * y, 2)))))
                + x;

    }

    public static void main(String[] args){

        System.out.println(Calc(1, 2));

    }
}