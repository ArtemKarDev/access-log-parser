import java.util.Arrays;

public class PolyLine {

    private Point[] points;

    public PolyLine(){
        this.points = new Point[0];
    }

    public PolyLine(Point[] points){
        this.points = new Point[points.length];
        for (int i=0; i<points.length; i++){
            this.points[i] = points[i];
        }
    }

    public Line[]  getLines(){
        Line[] lines = new Line[this.points.length-1];
        for(int i=0; i<this.points.length-1; i++){
            lines[i] = new Line(this.points[i],this.points[i+1]);
        }
            {
        }
        return lines;
    }

    public Double getLength(){
        Double sum = 0.0;
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
