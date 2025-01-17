import java.util.Arrays;

public class PolyLine implements Main.Measurable {

    Point[] points;

    public PolyLine(){
        this.points = new Point[0];
    }

    public PolyLine(Point ... points){
        this.points = points;
    }

    public Line[]  getLines(){
        Line[] lines = new Line[this.points.length-1];
        for(int i=0; i<this.points.length-1; i++){
            lines[i] = new Line(this.points[i],this.points[i+1]);
        }
        return lines;
    }

    public double getLength(){
        double sum = 0;
        for(int i=0; i<this.points.length-1; i++){
            sum += this.getLengthBetweenPoints(points[i],points[i+1]);
        }
        return sum;
    }

    private Double getLengthBetweenPoints(Point a1, Point a2){
        return (Math.sqrt ((a2.x - a1.x)*(a2.x - a1.x) + (a2.y - a1.y)*(a2.y - a1.y)));
    }

    public String toString(){
        return "Линия: " + Arrays.toString(points);
    }

}

class ClosedPolyLine extends PolyLine{

    public ClosedPolyLine(Point ... points){
        super(points);
    }

    @Override
    public double getLength() {
        Point[] lastFirstPoints = {super.points[this.points.length-1],this.points[0]};
        PolyLine temp = new PolyLine(lastFirstPoints);
        return super.getLength() + temp.getLength();
    }
}