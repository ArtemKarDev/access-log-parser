public class Main {
    public static void main(String[] args) {

        Bird chijik = new Sparrow();
        System.out.print(chijik.getSpecies()+" ");
        chijik.sing();

        Bird cocoshka = new Cuckoo();
        System.out.print(cocoshka.getSpecies()+" ");
        cocoshka.sing();

        Bird popugai = new Parrot("Пусть всегда будет солнце!");
        System.out.print(popugai.getSpecies()+" ");
        popugai.sing();

        birdsMarket(new Sparrow(), new Cuckoo(), new Sparrow(),
                new Parrot("Пусть всегда будет солнце!"),
                new Cuckoo(), new Sparrow(),
                new Parrot("Пусть всегда будет солнце!"));
    }

public static void birdsMarket(Bird... birds){
        for(Bird bird: birds){
            bird.sing();
        }
}

public static void birdMarket(Singable object){
        object.sing();
}

interface Singable{
    void sing();
}

}
