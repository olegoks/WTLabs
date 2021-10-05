public class Task7 {

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){

        int[] arr = new int[]{ 1, 2, 7, 4, 2, 6, 0 };
        int n = 7;
        int i = 0;
        while (i < n - 1) {
            if (arr[i] > arr[i + 1]){
                swap(arr, i, i + 1);
                if (i > 0) i--;
            } else {
                i++;
            }
        }

        for ( var el : arr){
            System.out.println(el);
        }

    }

}
