package WarOnGaza;

public class Person {
    private String ID;
    private String name;
    private int age;
    private String Gender;
    private String address;
    private String ContactInfo;


    public Person(String ID, String name, int age, String gender, String address) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        Gender = gender;
        this.address = address;
    }

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
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInfo() {
        return ContactInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", Gender='" + Gender + '\'' +
                ", address='" + address + '\'' +
                ", ContactInfo='" + ContactInfo + '\'' +
                '}'+ "\n";
    }
}

