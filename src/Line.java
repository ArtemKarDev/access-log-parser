public class Line {

    Point pStart, pEnd;

    public Line(int x1, int y1, int x2, int y2){
        this.pStart = new Point(x1,y1);
        this.pEnd = new Point(x2,y2);
    }

    public Line(Point pStart, Point pEnd){
        this.pStart = pStart;
        this.pEnd = pEnd;
    }

    public Double getLength(){
        return (Math.sqrt ((this.pEnd.x - this.pStart.x)*(this.pEnd.x - this.pStart.x) + (this.pEnd.y - this.pStart.y)*(this.pEnd.y - this.pStart.y)));
    }

    public String toString(){
        return "Линия от " + this.pStart + " до " + this.pEnd;
    }

}
