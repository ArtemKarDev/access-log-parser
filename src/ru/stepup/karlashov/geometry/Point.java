package ru.stepup.karlashov.geometry;

import java.util.Objects;

public class Point implements Cloneable{
    int x,y;

    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void setX(int x){
        this.x = x;
    }

    public String toString(){
        return "Point{" + x +
                ", " + y +'}';
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int hash = 2;
        hash = prime * hash + Objects.hashCode(this.x);
        hash = prime * hash + Objects.hashCode(this.y);
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        final Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public Point clone() throws CloneNotSupportedException {
        Point tmp = (Point) super.clone();
        tmp.x = this.x;
        tmp.y = this.y;
        return tmp;
    }


}
