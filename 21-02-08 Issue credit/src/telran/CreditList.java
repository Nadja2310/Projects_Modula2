package telran;

public class CreditList {
    String name;
    long time;

    public CreditList(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "CreditList{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
