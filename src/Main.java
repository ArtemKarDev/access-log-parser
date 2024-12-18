
public class Main {
    public static void main(String[] args) {

        Point a1 = new Point(1,3);
        Point a2 = new Point(5,8);

        Line l1 = new Line(a1,a2);
        Line l2 = new Line(10,11, 15,19);
        Line l3 = new Line(l1.pEnd,l2.pStart);

        System.out.println(l3);

        a2.x = 116;
        a2.y = 115;
        l2.pStart.x = 119;
        l2.pStart.y = 117;

        System.out.println(l3);

        System.out.println("Длина 3х линий: "+(l1.getLength()+l2.getLength()+l3.getLength()));

    }
}
