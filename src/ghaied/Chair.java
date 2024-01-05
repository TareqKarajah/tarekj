package ghaied;
import java.util.Date;
public class Chair {
    double weight;
    double distaanceFromFrontWall;
    String color;
    Date dateOfManufacture;

    public Chair(){
        weight = 0;
        distaanceFromFrontWall = 0;
        color = "white";
        dateOfManufacture = new Date();
    }

    Chair(double weight, double distaanceFromFrontWall, String color, Date dateOfManufacture){
        this.weight = weight;
        this.distaanceFromFrontWall = distaanceFromFrontWall;
        this.color = color;
        this.dateOfManufacture = dateOfManufacture;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDistaanceFromFrontWall() {
        return distaanceFromFrontWall;
    }

    public void setDistaanceFromFrontWall(double distaanceFromFrontWall) {
        this.distaanceFromFrontWall = distaanceFromFrontWall;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }
    public void moveChairForward(double distance){
        distaanceFromFrontWall += distance;
    }
    public void moveChairBackward(double distance){
        distaanceFromFrontWall -= distance;
    }
}
