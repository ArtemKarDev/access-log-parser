import ru.stepup.karlashov.Student;
import ru.stepup.karlashov.animal.Bird;
import ru.stepup.karlashov.animal.Singable;
import ru.stepup.karlashov.geometry.Areable;
import ru.stepup.karlashov.geometry.Measurable;

public class Main {
    public static void main(String[] args) {


    }

    public static double sumAllAreas(Areable... objects){
        double result = 0;
        for (Areable item : objects) {
            result += item.getArea();
        }
        return result;
    }


    public static double length(Measurable arg){
        return arg.getLength();
    }


    public static void birdsMarket(Bird... birds){
        for(Bird bird: birds){
            bird.sing();
        }
    }

    public static void birdMarket(Singable object){
        object.sing();
    }


}
