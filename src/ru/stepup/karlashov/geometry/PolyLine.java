package ru.stepup.karlashov.geometry;
import java.util.Arrays;
import java.util.Objects;

public class PolyLine implements Measurable, Cloneable {

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



    @Override
    public int hashCode(){
        final int prime = 31;
        int hash = 2;
        hash = prime * hash + Objects.hashCode(this.points);
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        PolyLine other = (PolyLine) obj;
        for(int i=0; i< this.points.length; i++){
            if (points[i].x != other.points[i].x || points[i].y != other.points[i].y) {
                return false;
            }
        }
        return true;
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