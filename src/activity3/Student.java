package Lab2;

public abstract class Student extends Human {

    private int id;
    private String name;
    private char gender;
    private String school;

    public Student (int id, String name, char gender, String school) {
        super();
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.school = school;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGender(char gender) {
        if (!(gender == 'F' || gender == 'M')) {
            return;
        }
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    @Override
    public String toString() {
        return "s";
    }
}
