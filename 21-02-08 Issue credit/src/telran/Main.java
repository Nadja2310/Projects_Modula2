package telran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static final int CREDIT_NUMBER = 20;
    static final int NUMBER_PERSONS = 3;

    public static void main(String[] args) throws InterruptedException {

        Thread[] personThreads = new Thread[NUMBER_PERSONS];
        List<CreditList> results = new ArrayList<>();
        long startingTime = System.currentTimeMillis();

       personThreads[0] = new Thread(new Person("Tanya", CREDIT_NUMBER,
                results, startingTime, CategoryOfWorker.STABLE));

        personThreads[1] = new Thread(new Person("Petya", CREDIT_NUMBER,
                results, startingTime, CategoryOfWorker.STABLE_AND_FAST));
        personThreads[2] = new Thread(new Person("Vasya", CREDIT_NUMBER,
                results, startingTime, CategoryOfWorker.ENTHUSIAST));

        for (int i = 0; i < NUMBER_PERSONS; i++) {
            personThreads[i].start();
        }

        for (int i = 0; i < NUMBER_PERSONS; i++) {
            personThreads[i].join();
        }

        int i = 0;
        for (CreditList res : results) {
            System.out.println(++i + ". " + res.getTime() + ", " + res.getName());
        }
    }
}
