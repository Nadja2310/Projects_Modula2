package telran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //запустить 10 тараканов
        long startingTime = System.currentTimeMillis();

        List<Score> listScore = Collections.synchronizedList(new ArrayList<>());
        Tarakan tr1 = new Tarakan("Tarakan A", 10, listScore, startingTime);
        Thread thread1 = new Thread(tr1);
        thread1.start();
        Tarakan tr2 = new Tarakan("Tarakan B", 10, listScore, startingTime);
        Thread thread2 = new Thread(tr2);
        thread2.start();
        Tarakan tr3 = new Tarakan("Tarakan C", 10, listScore, startingTime);
        Thread thread3 = new Thread(tr3);
        thread3.start();
        Tarakan tr4 = new Tarakan("Tarakan D", 10, listScore, startingTime);
        Thread thread4 = new Thread(tr4);
        thread4.start();
        Tarakan tr5 = new Tarakan("Tarakan E", 10, listScore, startingTime);
        Thread thread5 = new Thread(tr5);
        thread5.start();
        Tarakan tr6 = new Tarakan("Tarakan F", 10, listScore, startingTime);
        Thread thread6 = new Thread(tr6);
        thread6.start();
        Tarakan tr7 = new Tarakan("Tarakan Q", 10, listScore, startingTime);
        Thread thread7 = new Thread(tr7);
        thread7.start();
        Tarakan tr8 = new Tarakan("Tarakan R", 10, listScore, startingTime);
        Thread thread8 = new Thread(tr8);
        thread8.start();
        Tarakan tr9 = new Tarakan("Tarakan S", 10, listScore, startingTime);
        Thread thread9 = new Thread(tr9);
        thread9.start();
        Tarakan tr10 = new Tarakan("Tarakan T", 10, listScore, startingTime);
        Thread thread10 = new Thread(tr10);
        thread10.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        thread7.join();
        thread8.join();
        thread9.join();
        thread10.join();

        System.out.println(listScore);

    }
}
