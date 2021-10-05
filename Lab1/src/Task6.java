import java.util.Arrays;
import java.util.ArrayList;

public class Task6 {

    public static void main(String[] args){

        int n = 10;
        var input = new int[n];

        for(int i = 0; i < n; i++)
            input[i] = i;
        var res = new int[n][n];
        int index = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++, index = (index + 1) % n) {
                res[row][col] = input[index];
            }
            index = (index + 1) % n;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }

        }


    }
