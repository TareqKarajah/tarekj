package WarOnGaza;

public abstract class Person {
    private String ID;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String ContactInfo;

    public Person(String ID, String name, int age, String gender, String address, String contactInfo) {
        // validate the age
        validatation(name, age, gender, address, contactInfo);
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.ContactInfo = contactInfo;
    }

    public void validatation(String name, int age, String gender, String address, String contactInfo) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120");
        }
        if (name.length() < 3 || name.length() > 20) {
            throw new IllegalArgumentException("Name must be between 3 and 20 characters");
        }
        if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
            throw new IllegalArgumentException("Gender must be either 'male' or 'female'");
        }
        if (address.length() < 1 || address.length() > 50) {
            throw new IllegalArgumentException("Address must be between 5 and 50 characters");
        }
        if (contactInfo.length() != 10 ) {
            throw new IllegalArgumentException("ContactInfo must be 10 characters");
        }
    }

    public Person() {
    }
    // setters and getters for all the attributes

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

    // string representation of the object, return all the information about the
    // person
    @Override
    public abstract String toString();

}
