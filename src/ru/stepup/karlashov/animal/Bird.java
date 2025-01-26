package ru.stepup.karlashov.animal;
import java.util.Random;

public abstract class Bird implements Singable {
    String species;

    String getSpecies(){
        return this.species;
    }

    public abstract void sing();


    public static void birdsMarket(Bird... birds){
        for(Bird bird: birds){
            bird.sing();
        }
    }

    public static void birdMarket(Singable object){
        object.sing();
    }

}


class Sparrow extends Bird{
    public Sparrow(){
        this.species = "воробей";
    }

    @Override
    public void sing(){
        System.out.println("чырык");
    }

}

class Cuckoo extends Bird{

    public Cuckoo(){
        this.species = "кукушка";
    }

    @Override
    public void sing(){
        int count = new Random().nextInt(10);
        for(int i = 0; i < count; i++){
            System.out.print("ку-ку ");
        }
        System.out.println("ку-ку");
    }

}

class Parrot extends Bird{
    public String text;

    public Parrot(String text) {
        this.species = "попугай";
        this.text = text;
    }

    @Override
    public void sing(){
        int count = new Random().nextInt(this.text.length());
        System.out.println(this.text.charAt(0)+this.text.substring(1,count));
    }


}

