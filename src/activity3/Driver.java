package Lab2;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<Tawjihi> students = new ArrayList<>();
        Tawjihi ahmad = new Scientific(1, 001, "ahmad", 'm', "elbireh");
        ahmad.addSubject(new Subject("arabic", "mandatory", 97));
        ahmad.addSubject(new Subject("english", "mandatory", 98));
        ahmad.addSubject(new Subject("physics", "mandatory", 97));
        ahmad.addSubject(new Subject("math", "mandatory", 94));
        ahmad.addSubject(new Subject("chemistry", "ElectiveI", 100));
        ahmad.addSubject(new Subject("biology", "ElectiveI", 98));
        ahmad.addSubject(new Subject("religion", "ElectiveII", 99));
        ahmad.addSubject(new Subject("technology", "ElectiveII", 97));
        students.add(ahmad);
        Tawjihi muna = new Scientific(2, 002, "muna", 'f', "ramallah");
        muna.addSubject(new Subject("arabic", "mandatory", 89));
        muna.addSubject(new Subject("english", "mandatory", 99));
        muna.addSubject(new Subject("physics", "mandatory", 67));
        muna.addSubject(new Subject("math", "mandatory", 95));
        muna.addSubject(new Subject("chemistry", "ElectiveI", 86));
        muna.addSubject(new Subject("biology", "ElectiveI", 88));
        muna.addSubject(new Subject("religion", "ElectiveII", 92));
        muna.addSubject(new Subject("technology", "ElectiveII", 98));
        students.add(muna);
        Tawjihi Khaled = new Scientific(3, 003, "khaled", 'm', "ramallah");
        Khaled.addSubject(new Subject("Arabic", "mandatory", 90));
        Khaled.addSubject(new Subject("English", "mandatory", 95));
        Khaled.addSubject(new Subject("Physics", "mandatory", 70));
        Khaled.addSubject(new Subject("Math", "mandatory", 60));
        Khaled.addSubject(new Subject("Chemistry", "ElectiveI", 79));
        Khaled.addSubject(new Subject("Biology", "ElectiveI", 86));
        Khaled.addSubject(new Subject("Religion", "ElectiveII", 89));
        Khaled.addSubject(new Subject("Technology", "ElectiveII", 95));
        students.add(Khaled);
        Tawjihi samira = new Literary(4, 004, "samira", 'f', "elbireh");
        samira.addSubject(new Subject("Arabic", "mandatory", 80));
        samira.addSubject(new Subject("English", "mandatory", 80));
        samira.addSubject(new Subject("Math", "mandatory", 80));
        samira.addSubject(new Subject("History", "mandatory", 80));
        samira.addSubject(new Subject("Geography", "ElectiveI", 60));
        samira.addSubject(new Subject("Religion", "ElectiveI", 80));
        samira.addSubject(new Subject("Scientific Culture", "ElectiveII", 80));
        samira.addSubject(new Subject("Technology", "ElectiveII", 71));
        students.add(samira);
        Tawjihi yousef = new Literary(5, 005, "yousef", 'm', "elitehad");
        yousef.addSubject(new Subject("Arabic", "mandatory", 95));
        yousef.addSubject(new Subject("English", "mandatory", 92));
        yousef.addSubject(new Subject("Math", "mandatory", 68));
        yousef.addSubject(new Subject("History", "mandatory", 90));
        yousef.addSubject(new Subject("Geography", "ElectiveI", 93));
        yousef.addSubject(new Subject("Religion", "ElectiveI", 95));
        yousef.addSubject(new Subject("Scientific Culture", "ElectiveII", 88));
        yousef.addSubject(new Subject("Technology", "ElectiveII", 92));
        students.add(yousef);

        Tawjihi yusra = new Literary(6, 006, "yusra", 'f', "ramallah");
        yusra.addSubject(new Subject("Arabic", "mandatory", 95));
        yusra.addSubject(new Subject("English", "mandatory", 82));
        yusra.addSubject(new Subject("Math", "mandatory", 88));
        yusra.addSubject(new Subject("History", "mandatory", 92));
        yusra.addSubject(new Subject("Geography", "ElectiveI", 73));
        yusra.addSubject(new Subject("Religion", "ElectiveI", 85));
        yusra.addSubject(new Subject("Scientific Culture", "ElectiveII", 90));
        yusra.addSubject(new Subject("Technology", "ElectiveII", 69));
        students.add(yusra);
//        find out the student with the highest average in each branch
        double maxS = 0;
        double maxL = 0;
        Tawjihi maxSstudent = null;
        Tawjihi maxlstuent = null;
        for (Tawjihi student : students) {
            if (student instanceof Scientific) {
                if (student.calculateAverage() > maxS) {
                    maxS = student.calculateAverage();
                    maxSstudent = student;
                }
            }
            if (student instanceof Literary) {
                if (student.calculateAverage() > maxL) {
                    maxL = student.calculateAverage();
                    maxlstuent = student;
                }
            }
        }
//        print the top students with their averages
        for (Tawjihi student : students) {
            System.out.println(student.toString());
        }
        System.out.println("The top student in scientific branch is: " + maxSstudent.getName() + "\t\t\t" + String.format("%.1f", maxSstudent.calculateAverage()));
        System.out.println("the top student  in literary branch is:  " + maxlstuent.getName() + "\t\t\t" + String.format("%.1f", maxlstuent.calculateAverage()));

//    print the students in ascending order. according to their averages
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size() - 1; j++) {
                if (students.get(j).calculateAverage() > students.get(j + 1).calculateAverage()) {
                    Tawjihi temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
        for (Tawjihi student : students) {
            System.out.println(student.toString());
        }

    }

}


