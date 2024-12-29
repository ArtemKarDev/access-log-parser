import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {

//        Point a1 = new Point(1,5);
//        Point a2 = new Point(2,8);
//        Point a3 = new Point(5,3);
//        Point a4 = new Point(8,9);
//
//        Point[] listPoints = {a1,a2,a3,a4};
//
//        PolyLine pl1 = new PolyLine(listPoints);
//        System.out.println(pl1);
//        System.out.println("Длина ломаной линии: "+ pl1.getLength());
//        System.out.println(Arrays.toString(pl1.getLines()));
//
//        Double sum = 0.0;
//        Line[] lines = pl1.getLines();
//        for (int i=0; i<lines.length; i++){
//            sum+= lines[i].getLength();
//        }
//        System.out.println("Длина массива линий: "+ sum);
//        a2.x = 12;
//        System.out.println(a2);
//        System.out.println(pl1);
//        System.out.println(Arrays.toString(pl1.getLines()));


        //City Kostroma = new City("Kastra",{new City.Path("Yarik",2)});
        City Kostroma = new City("Kostroma");
        City Yarik = new City("Yarik");
        City Nerehta = new City("Nerehta");
        Kostroma.addPath(Yarik,3);
        Kostroma.addPath(Nerehta,1);
        City.Path pathYarikNerehta = new City.Path(Nerehta,2);
        City.Path pathNerehtaYarik = new City.Path(Yarik,2);
        Yarik.addPath(pathYarikNerehta);
        Nerehta.addPath(pathNerehtaYarik);
        System.out.println(Kostroma);
        System.out.println(Yarik);
        System.out.println(Nerehta);

        System.out.println("Путешествие: "+Kostroma.travelBy(2));

//        Fraction fraction = new Fraction(3,5);
//        System.out.println(fraction);



    }

}
