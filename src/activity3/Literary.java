package Lab2;

public class Literary extends Tawjihi {
    public Literary(int seatingNum, int id, String name, char gender, String school) {
        super(seatingNum, id, name, gender, school);
    }

    @Override
    public double calculateAverage() {
        double average = 0;
        int count = 6;
        double elective1 = 0;
        double elective2 = 0;
        // calculate the average of mandatory subjects
        for (Subject subject : super.getSubjects()) {
            if (subject.getType().equalsIgnoreCase("mandatory")) {
                average += subject.getMark();
            }
        }
        // calculate the average of elective subjects
        for (Subject subject : super.getSubjects()) {
            if (subject.getType().equalsIgnoreCase("electiveI")) {
                if (subject.getMark() > elective1) {
                    elective1 = subject.getMark();
                }
            }
            if (subject.getType().equalsIgnoreCase("electiveII")) {
                if (subject.getMark() > elective2) {
                    elective2 = subject.getMark();
                }
            }
        }
        //adding the average of elective subjects to the average of mandatory subjects
        average += elective1 + elective2;
        return average / count;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }


    //    @Override
    public String toString() {
        return super.getName() + "\t\t\t" + String.format("%.1f", calculateAverage()) + "\t\t\t" + super.getSubjects().toString();
    }
}
