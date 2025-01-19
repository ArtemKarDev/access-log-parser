

public class Main {
    public static void main(String[] args) {
        Point point1 = new Point(5,5);

        Circle circle1 = new Circle(point1,3);
        System.out.println(circle1.getArea());

        Square square = new Square(point1, 3);
        System.out.println(square.getArea());

        Rectangle rectangle = new Rectangle(point1,3,4);
        System.out.println(rectangle.getArea());

        System.out.println(sumAllAreas(circle1,square,rectangle));
    }

    public static double sumAllAreas(Areable... objects){
        double result = 0;
        for(Areable item: objects){
            result += item.getArea();
        }
        return result;
}

    public interface Areable{
        double getArea();
    }

}
