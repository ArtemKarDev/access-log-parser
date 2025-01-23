package ru.stepup.karlashov.geometry;

import java.util.Objects;

public class Line implements Measurable , Cloneable{

    Point pStart, pEnd;

    public Line(int x1, int y1, int x2, int y2){
        this.pStart = new Point(x1,y1);
        this.pEnd = new Point(x2,y2);
    }

    public Line(Point pStart, Point pEnd){
        this.pStart = pStart;
        this.pEnd = pEnd;
    }

    public void setPStart(int x, int y){
        this.pStart = new Point(x,y);
    }

    public double getLength(){
        return (Math.sqrt ((this.pEnd.x - this.pStart.x)*(this.pEnd.x - this.pStart.x) + (this.pEnd.y - this.pStart.y)*(this.pEnd.y - this.pStart.y)));
    }

    public String toString(){
        return "Линия от " + this.pStart + " до " + this.pEnd;
    }



    @Override
    public int hashCode(){
        final int prime = 31;
        int hash = 2;
        hash = prime * hash + Objects.hashCode(this.pStart);
        hash = prime * hash + Objects.hashCode(this.pEnd);
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        final Line other = (Line) obj;
        return this.pStart == other.pStart && this.pEnd == other.pEnd;
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        Line tmp =  (Line) super.clone();
        tmp.pStart = new Point(this.pStart.x,this.pStart.y);
        tmp.pEnd = new Point(this.pEnd.x,this.pEnd.y);
        return tmp;
    }


}