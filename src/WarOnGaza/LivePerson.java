package WarOnGaza;

public class LivePerson extends Person implements Cloneable{


    public LivePerson(String ID, String name, int age, String gender, String address, String contactInfo) {
        super(ID, name, age, gender, address, contactInfo);
        
    }
    public LivePerson(String name) {
        super.setName(name);
    }

//    method to deep copy the object using clone method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new LivePerson(super.getID(), super.getName(), super.getAge(), super.getGender(), super.getAddress(), super.getContactInfo());
    }

    @Override
//    String representation of the object.
    public String toString() {
        return "Live Person{" +
                "ID='" + super.getID() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", Gender='" + super.getGender() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                ", ContactInfo='" + super.getContactInfo() + '\'' +
                '}';
    }
}
