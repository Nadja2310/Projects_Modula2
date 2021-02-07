package telran;

public class Score {
    String name;
    long score;

    public Score(String name, long score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "\nScore{" +
                name + '\'' +
                ", score=" + score +
                '}';
    }

}
