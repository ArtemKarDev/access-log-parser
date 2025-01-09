public class Main {
    public static void main(String[] args) {

        Square s1 = new Square(4,4,4);

        System.out.println(s1);
        s1.setX(0).setY(0).setSideLength(2);
        System.out.println(s1);

        Square s2 = new Square(-4,-4,-4);

    }
}
