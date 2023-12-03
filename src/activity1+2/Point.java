package lab4;

import java.util.Objects;

public class Point implements Comparable<Point> ,Cloneable{
    private int x;
    private int y;

    public Point(){
     x=0;
     y=0;
    }
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object p2) {
        if (this == p2) return true;
        if (p2 == null || getClass() != p2.getClass()) return false;
        Point point = (Point) p2;
        return getX() == point.getX() && getY() == point.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public int compareTo(Point p2) {
        if((this.x>p2.x || this.x==p2.x )&&(this.y> this.y)){
            System.out.println("p1 > p2");
            return 1;
        }
        return 0;
    }

    @Override
    public Point clone() throws CloneNotSupportedException {
    return (Point) super.clone();
    }



}
