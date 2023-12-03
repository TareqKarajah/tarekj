package Lab2;
//Make Subject class Comparable.
public class Subject implements Comparable<Subject> {
// Two subjects are
//    compared if they both have the same title according to the mark. Override the
//    equals method.
    private String title;
    private String type;
    private int mark;
private int maxMark = 100;


    public Subject(String title, String type, int mark) {
        this.title = title;
        this.type = type;
        this.mark = mark;

    }

    public Subject(String title, String type, int mark, int maxMark) {
        this.title = title;
        this.type = type;
        this.mark = mark;
        this.maxMark = maxMark;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (!(type.equalsIgnoreCase("mandatory") ||
                type.equalsIgnoreCase("electiveI") ||
                type.equalsIgnoreCase("electiveII"))) {
            return;
        }
        this.type = type;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }





    @Override
    public String toString() {
        return title + '(' +
                +mark +
                ')';
    }

    @Override
    public int compareTo(Subject o) {
        if (this.title.equals(o.title)) {
            return this.mark - o.mark;
        }
        return this.title.compareTo(o.title);
    }


        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Subject) {
                Subject s = (Subject) obj;
                return this.title.equals(s.title) && this.mark == s.mark;
            }
            return false;
        }
}
