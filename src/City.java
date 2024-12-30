import java.util.Arrays;

public class City {

    private Path [] paths;
    private String name;
    private Path path;

    public static class Path {
        private City city;
        private int price;

        public Path(City city, int price){
            this.city = city;
            this.price = price;
        }
        @Override
        public String toString(){
            return this.city.getName() +" - " +this.price;
        }

    }


    public City(String name){
        this.name = name;
        this.paths = new Path[0];
    }
    public City(String name, Path[] paths){
        this.name = name;
        this.paths = new Path[paths.length];
        for(int i = 0; i<paths.length; i++ ){
            this.paths[i] = paths[i];
        }
    }

    public void addPath(City city, int price){
        this.paths = Arrays.copyOf(this.paths,this.paths.length+1);
        this.paths[this.paths.length-1] = new Path(city,price);
    }

    public void addPath(Path path){
        this.paths = Arrays.copyOf(this.paths,this.paths.length+1);
        this.paths[this.paths.length-1] = path;
    }


    public City travelBy(int n){
        City currentCity = this;
        for (int i=0; i<n; i++){
            if (currentCity.paths.length == 0){
                return null;
            }
            currentCity = currentCity.paths[0].city;
        }
        return currentCity;
    }


    public String getName(){
        return this.name;
    }

    public String toString(){
        return "Город: " + this.getName() +". "+"Маршруты: "+ Arrays.toString(paths);
    }

}
