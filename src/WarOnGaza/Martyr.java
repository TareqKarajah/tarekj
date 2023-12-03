package WarOnGaza;

public class Martyr extends Person{
    private String DateOfMartyrdom;
    private String CauseOfDeath;
    private String PlaceOfDeath;

        public Martyr(String ID, String name, int age, String gender, String address, String DateOfMartyrdom, String CauseOfDeath, String PlaceOfDeath) {
            super(ID, name, age, gender, address);
            this.DateOfMartyrdom = DateOfMartyrdom;
            this.CauseOfDeath = CauseOfDeath;
            this.PlaceOfDeath = PlaceOfDeath;
        }

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


    @Override
    public String toString() {
            // return name
        return
                "DateOfMartyrdom='" + DateOfMartyrdom + '\'' +
                ", CauseOfDeath='" + CauseOfDeath + '\'' +
                ", PlaceOfDeath='" + PlaceOfDeath + '\'' +
                '}'+super.toString()  ;

    }
}

