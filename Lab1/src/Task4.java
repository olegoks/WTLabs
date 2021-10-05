import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 {

    public static boolean isPrime(int n){
        int half = n / 2;
        if (n == 0 || n == 1)
        {
            return false;
        }

        for (int i = 2; i <= half; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        for (Integer el : arr) {
            if(isPrime(el)){
                System.out.println(el);
            }
        }

    }
}