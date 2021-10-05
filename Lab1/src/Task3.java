import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {

    private static class TgResult {
        public Float x_;
        public Float y_;

        public TgResult(Float x, Float y) {
            x_ = x;
            y_ = y;
        }
    }


    private static class TgCounter {
        public static List<TgResult> Count (Float start, Float end, Float step) {
            int arrSize = (int)Math.floor((end - start) / step) + 1;
            List<TgResult> tgResultList =  new ArrayList<>(arrSize);

            for (float i = start; i < end; i+= step) {
                TgResult currentreses = new TgResult(i, (float) Math.tan(i));
                tgResultList.add(currentreses);
            }

            return tgResultList;
        }
    }



    public static void main(String[] args){
       List<TgResult> res = TgCounter.Count(0f, 8f, 2f);
        for(int i = 0; i < res.size(); i++){
            System.out.print(res.get(i).x_ + "        ");
        }
        System.out.println();
        for(int i = 0; i < res.size(); i++){
            System.out.print(res.get(i).y_ + "  ");
        }
    }
}