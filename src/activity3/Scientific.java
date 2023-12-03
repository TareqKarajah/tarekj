package Lab2;

public class Scientific extends Tawjihi {

    public Scientific(int seatingNum, int id, String name, char gender, String school) {
        super(seatingNum, id, name, gender, school);

    }

    @Override
    public double calculateAverage() {
        double average = 0;
        int count = 6;
        double elective1 = 0;
        double elective2 = 0;

        for (Subject subject : super.getSubjects()) {
            if (subject.getType().equalsIgnoreCase("mandatory")) {
                average += subject.getMark();
            }
//            get the max of elective1 and elective2
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
        average += elective1 + elective2;
        return average / count;

    }

    @Override
    public String toString() {
        return super.getName() + "\t\t\t" + String.format("%.1f", calculateAverage()) + "\t\t\t" + super.getSubjects().toString();
    }

    @Override
    public int compareTo(Tawjihi o) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
