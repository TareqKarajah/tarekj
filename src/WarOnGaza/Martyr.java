package WarOnGaza;

public class Martyr extends Person implements Cloneable {
    private String DateOfMartyrdom;
    private String CauseOfDeath;
    private String PlaceOfDeath;

    public Martyr(String name) {
        super.setName(name);

    }
    //   constructor for the class , with the person attributes .
    public Martyr(String ID, String name, int age, String gender, String address, String contactInfo, String DateOfMartyrdom, String CauseOfDeath, String PlaceOfDeath) {
        super(ID, name, age, gender, address, contactInfo);
        
        this.DateOfMartyrdom = DateOfMartyrdom;
        this.CauseOfDeath = CauseOfDeath;
        this.PlaceOfDeath = PlaceOfDeath;
    }

    //    setters and getters for all the attributes
    public String getDateOfMartyrdom() {
        return DateOfMartyrdom;
    }

    public void setDateOfMartyrdom(String dateOfMartyrdom) {
        DateOfMartyrdom = dateOfMartyrdom;
    }

    public String getCauseOfDeath() {
        return CauseOfDeath;
    }

    public void setCauseOfDeath(String causeOfDeath) {
        CauseOfDeath = causeOfDeath;
    }

    public String getPlaceOfDeath() {
        return PlaceOfDeath;
    }


    public void setPlaceOfDeath(String placeOfDeath) {
        PlaceOfDeath = placeOfDeath;
    }

//       method to deep copy the object using clone method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Martyr(super.getID(), super.getName(), super.getAge(), super.getGender(), super.getAddress(), super.getContactInfo(), this.DateOfMartyrdom, this.CauseOfDeath, this.PlaceOfDeath);
    }

    //   String representation of the object.
    @Override
    public String toString() {
        return "Martyr{" +
                "ID='" + super.getID() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", Gender='" + super.getGender() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                ", ContactInfo='" + super.getContactInfo() + '\'' +
                "DateOfMartyrdom='" + this.DateOfMartyrdom + '\'' +
                ", CauseOfDeath='" + this.CauseOfDeath + '\'' +
                ", PlaceOfDeath='" + this.PlaceOfDeath + '\'' +
                '}';
    }
}

