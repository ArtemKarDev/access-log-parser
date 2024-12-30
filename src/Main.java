import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {

        City cityA = new City("A");
        City cityB = new City("B");
        City cityC = new City("C");
        City cityD = new City("D");
        City cityE = new City("E");
        City cityF = new City("F");

        cityA.addPath(cityB,5);
        cityA.addPath(cityD,6);
        cityA.addPath(cityF,1);

        cityB.addPath(cityA,5);
        cityB.addPath(cityC,3);

        cityC.addPath(cityB,3);
        cityC.addPath(cityD,4);

        cityD.addPath(cityA,6);
        cityD.addPath(cityC,4);
        cityD.addPath(cityE,2);

        cityE.addPath(cityF,2);

        cityF.addPath(cityB,1);
        cityF.addPath(cityE,2);

        System.out.println("Путешествие: "+cityB.travelBy(3));

    }

}
