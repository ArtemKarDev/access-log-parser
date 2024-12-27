public class City {

    private Path[] paths;
    private String name;
    private Path path;

    public class Path {

        private String city;
        private int price;

        public Path(String city, int price){
            this.city = city;
            this.price = price;
        }
        @Override
        public String toString(){
            return this.city+" "+this.price;
        }

    }



    public City(String name){
        this.name = name;
    }
    public City(String name, Path[] paths){
        this.name = name;
        this.paths = new Path[path];
        for(int i = 0; i<paths.length; i++ ){
            this.paths[i] = new Path(paths[i]);
        }
    }

    public String toString(){
        return "Город: " + this.name;
    }

}
