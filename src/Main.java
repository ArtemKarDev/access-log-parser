import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Point a1 = new Point(1,5);
        Point a2 = new Point(2,8);
        Point a3 = new Point(5,3);
        Point a4 = new Point(8,9);

        Point[] listPoints = {a1,a2,a3,a4};

        PolyLine pl1 = new PolyLine(listPoints);
        System.out.println(pl1);
        System.out.println("Длина ломаной линии: "+ pl1.getLength());
        System.out.println(Arrays.toString(pl1.getLines()));

        double sum = 0.0;
        Line[] lines = pl1.getLines();
        for (int i=0; i<lines.length; i++){
            sum+= lines[i].getLength();
        }
        System.out.println("Длина массива линий: "+ sum);

        PolyLine cpl1 = new ClosedPolyLine(listPoints);
        System.out.println("Замнкнутая ломаная линия: "+cpl1);
        System.out.println("Длина замнкнутой ломаной линии: "+cpl1.getLength());

        System.out.println(length(pl1));
        System.out.println(length(cpl1));

        MyString myString = new MyString("Abra Cadabra");
        System.out.println(length(myString));

    }

    public static double length(Measurable arg){
        return arg.getLength();
    }

    public interface Measurable {
        double getLength();
    }

}
