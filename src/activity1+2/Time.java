package lab4;


public class Time implements Comparable<Time>, Cloneable {
    private long elapsedTime;

    public Time() {
        elapsedTime = System.currentTimeMillis();

    }

    public Time(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public Time(int hour, int mins, int seconds) {
        this.elapsedTime = hour * 60 * 60 * 1000 + mins * 60 * 1000 + seconds * 1000;
    }

    public int getHour() {
        return (int) (elapsedTime / 60 * 60 * 1000) % 24;
    }

    public int getMinute() {
        return (int) (elapsedTime / 1000 / 60) % 60;
    }

    public int getSecond() {
        return (int) (elapsedTime / 1000) % 60;
    }

    public int getSeconds() {
        return (int) (elapsedTime / 1000);
    }

    @Override
    public String toString() {
        return "Time{" +
                getHour() + "Hour"
                + getMinute() + "munites"
                + getSecond() + "seconds" + '}';
    }

    @Override
    public int compareTo(Time otherTime) {
        if (this.elapsedTime > otherTime.elapsedTime) {
            return 1;

        } else if (this.elapsedTime < otherTime.elapsedTime) {
            return -1;
        } else {
            return 0;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
