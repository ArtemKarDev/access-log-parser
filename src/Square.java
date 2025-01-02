public class Square {

    private int x;
    private int y;
    private int sideLength;

    public Square setX(int x) {
        this.x = x;
        return this;
    }
    public Square setY(int y) {
        this.y = y;
        return this;
    }
    public Square(int x, int y, int sideLength){
        this.x = x;
        this.y = y;
        if(sideLength<0){throw new IllegalArgumentException();}
        else {this.sideLength = sideLength;}

    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        if(sideLength<0){throw new IllegalArgumentException();}
        else {this.sideLength = sideLength;}
    }

    public String toString(){
        return "Квадрат в точке " + this.x+","+ this.y + " со стороной " + this.sideLength;
    }

}
