public class Task2 {

    private static class Point {
        private double x_;
        private double y_;

        public Point(double x, double y) {
            x_ = x;
            y_ = y;
        }
        public double GetX(){
            return x_;
        }
        public double GetY(){
            return y_;
        }
    }

    private static class Shape {
        public Point points_[];

        public Shape(){
            points_ = new Point[]{
                            new Point(4, 5),
                            new Point(4, 0),
                            new Point(6, 0),
                            new Point(6, -3),
                            new Point(-6, -3),
                            new Point(-6, 0),
                            new Point(-4, 0),
                            new Point(-4, 5),
                    };
        }

        public boolean isPointInTheShape(Point point){

                boolean result = false;
                for (int i = 0, j = points_.length - 1; i < points_.length; j = i++) {
                    if ((points_[i].y_ > point.y_) != (points_[j].y_ > point.y_) &&
                            (point.x_ < (points_[j].x_ - points_[i].x_) * (point.y_ - points_[i].y_) / (points_[j].y_ - points_[i].y_) + points_[i].x_)) {
                        result = !result;
                    }
                }
                return result;

        }

    }


    public static void main(String[] args){

        Shape shape = new Shape();
        Point point = new Point( 1, 1 );
        System.out.println(shape.isPointInTheShape(point));

    }
}