package telran;

import java.util.List;
import java.util.Random;

public class Person implements Runnable {
    final private String name;
    final private int numberOfCredits;
    final List<CreditList> creditList;
    private long startingTime;
    private CategoryOfWorker categoryOfWorker;
    private final Random random = new Random();
    private int enlightenment;
    private final int percentEnlightenment = 25;

    public Person(String name, int numberOfCredits, List<CreditList> creditList, long startingTime, CategoryOfWorker categoryOfWorker) {
        this.name = name;
        this.numberOfCredits = numberOfCredits;
        this.creditList = creditList;
        this.startingTime = startingTime;
        this.categoryOfWorker = categoryOfWorker;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfCredits; i++) {
            int creditTime;

            if (categoryOfWorker == CategoryOfWorker.ENTHUSIAST && enlightenment != 0 && enlightenment < 4) {
                creditTime = random.nextInt(51) + 50;
                enlightenment++;
               // System.out.println(enlightenment + "  " + creditTime);
            } else creditTime = creditExtensionTime();

            if (categoryOfWorker == CategoryOfWorker.ENTHUSIAST && enlightenment == 3)
                enlightenment = 0;


            try {
                Thread.sleep(creditTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long totalTime = System.currentTimeMillis() - startingTime;
        creditList.add(new CreditList(name, totalTime));
    }

    private int creditExtensionTime() {
        if (categoryOfWorker == CategoryOfWorker.STABLE)
            return random.nextInt(100) + 100;
        if (categoryOfWorker == CategoryOfWorker.ENTHUSIAST && random.nextInt(100) < percentEnlightenment) {
            enlightenment++;
            //System.out.println("enlightenment ");
            return random.nextInt(51) + 50;
        }
        return random.nextInt(100) + 200;

    }
}
