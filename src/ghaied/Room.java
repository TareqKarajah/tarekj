package ghaied;

public class Room {
    private int number;
    private double length;
    private double width;
    private Chair[] chairs;


    public Room(int number, double length, double width) {
        this.number = number;
        this.length = length;
        this.width = width;
        chairs = new Chair[100];
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Chair[] getChairs() {
        return chairs;
    }

    public void setChairs(Chair[] chairs) {
        this.chairs = chairs;
    }
public void displayRoomInfo(){
        int red = 0;
        int yellow = 0;
        int white = 0;
        for (Chair chair : chairs) {
            if (chair.getColor().equalsIgnoreCase("red")) {
                red++;
            } else if (chair.getColor().equalsIgnoreCase("yellow")) {
                yellow++;
            } else if (chair.getColor().equalsIgnoreCase("white")) {
                white++;
            }
        }
    System.out.println("\t"+number
            + "\t\t"+length
            + "\t"+ width
            + "\t\t"+ chairs.length
            + "\t\t\t" + red
            + "\t\t" + yellow
            + "\t\t" + white);
    }
}