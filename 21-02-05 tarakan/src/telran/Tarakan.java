package telran;

import java.util.List;

public class Tarakan implements Runnable{
    final private String name;
    final private int distance;
    final List<Score> scoreList;
    private  long startingTime;

    public Tarakan(String name, int distance, List<Score> scoreList, long startingTime) {
        this.name = name;
        this.distance = distance;
        this.scoreList = scoreList;
        this.startingTime = startingTime;
    }

    @Override
    public void run() {
        int sleepTime= (int) (50+Math.random()*50);
        for (int i = 0; i <distance ; i++) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // System.out.println(message);
            }
        }
        long score = System.currentTimeMillis() - startingTime;
        scoreList.add(new Score(name,score));
    }
}
