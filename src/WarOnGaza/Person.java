package WarOnGaza;

public abstract class Person {
    private String ID;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String ContactInfo;

    public Person(String ID, String name, int age, String gender, String address, String contactInfo) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.ContactInfo = contactInfo;
    }

    public Person() {
    }
//    setters and getters for all the attributes

    String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactInfo(String contactInfo) {
        ContactInfo = contactInfo;
    }

    public String getContactInfo() {
        return ContactInfo;
    }

//     string representation of the object, return all the information about the person
    @Override
    public abstract String toString();

}

