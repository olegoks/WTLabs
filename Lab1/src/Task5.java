import java.util.Arrays;
import java.util.ArrayList;

public class Task5 {

    public static void main(String[] args){

        var sequence = new ArrayList<Integer>();
        sequence.add(2);
        sequence.add(5);
        sequence.add(3);
        sequence.add(6);
        sequence.add(4);
        int length = sequence.size();
        int[] d = new int[length];
        for (int i = 0; i < length; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequence.get(j) < sequence.get(i)) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
        }
        int res = Arrays.stream(d).max().getAsInt();
        System.out.println(res);
    }
}