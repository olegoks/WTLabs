import java.util.ArrayList;

public class Task9 {

    private static class Basket{
        public static class Ball{
            public enum Color{
                Blue,
                Red
            }
            private Color color_;
            private Integer weight_;
            public Ball(Color color, Integer weight){
                color_ = color;
                weight_ = weight;
            }

            public Color GetColor(){
                return color_;
            }
            public Integer GetWeight(){
                return weight_;
            }
        }

        private ArrayList<Ball> balls_;

        public Basket(){
            balls_ = new ArrayList<>();
        }
        public Ball GetBall(Integer index){
            return balls_.get(index);
        }
        public Integer GetBallsNumber(){
            return balls_.size();
        }
        public void AddBall(Ball ball){
            balls_.add(ball);
        }

    }

    public static void main(String[] args){
        var basket = new Basket();
        basket.AddBall(new Basket.Ball(Basket.Ball.Color.Blue, 10));
        basket.AddBall(new Basket.Ball(Basket.Ball.Color.Red, 5));
        basket.AddBall(new Basket.Ball(Basket.Ball.Color.Blue, 20));
        basket.AddBall(new Basket.Ball(Basket.Ball.Color.Red, 10));
        basket.AddBall(new Basket.Ball(Basket.Ball.Color.Blue, 40));
        final Integer ballsNumber = basket.GetBallsNumber();
        Integer commonWeight = 0;
        Integer blueBallsNumber = 0;
        for(Integer i = 0; i < ballsNumber; i++){
            Basket.Ball curBall = basket.GetBall(i);
            commonWeight += curBall.GetWeight();
            if(curBall.GetColor() == Basket.Ball.Color.Blue){
                ++blueBallsNumber;
            }
        }
    }

}
