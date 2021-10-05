import java.util.ArrayList;

public class Task8 {

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){

       var firstSeq = new ArrayList<Integer>();
        for (int i = 0; i < 7; i += 2) {
            firstSeq.add(i);
        }
        var secondSeq  = new ArrayList<Integer>();
        for (int i = 1; i < 8; i += 2) {
            secondSeq.add(i);
        }

       for(int i = 0; i < firstSeq.size(); i++){
            for(int j = 0; j < secondSeq.size(); j++){
                if(firstSeq.get(i) <= secondSeq.get(j)){
                    secondSeq.add(j, firstSeq.get(i));
                    break;
                }
            }
       }

       for(var el : secondSeq)
        System.out.println(el);

    }

}
