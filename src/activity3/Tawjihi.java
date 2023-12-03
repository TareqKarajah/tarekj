package Lab2;

import java.util.ArrayList;
import java.util.List;

public abstract class Tawjihi extends Student implements Comparable<Tawjihi> {
    private int seatingNum;
    private int year;
    private  List<Subject> subjects = new ArrayList<>();


    public Tawjihi(int seatingNum, int id, String name, char gender, String school) {
        super(id, name, gender, school);
        this.seatingNum = seatingNum;
        this.year = 2022;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }


    public void addSubject(Subject s) {
        subjects.add(s);

    }

    public Subject getSubject(String title) {
        for (Subject subject : subjects) {

            if (subject.getTitle().equals(title)) {
                return subject;
            }
        }
        return null;
    }

    public abstract double calculateAverage();


    @Override
    public int compareTo(Tawjihi o) {
        if (this.calculateAverage() > o.calculateAverage()) {
            return 1;
        } else if (this.calculateAverage() < o.calculateAverage()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public abstract boolean equals(Object obj);

    public abstract String toString();
}
