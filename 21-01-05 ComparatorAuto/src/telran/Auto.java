package telran;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*public class Main {
    public static void main(String[] args) {
        Auto mazda = new Auto("Mazda", 4000, 2020);
        Auto opel = new Auto("Opel", 4000, 2019);
        Auto mercedes = new Auto("Mercedes", 1000, 2018);
        Auto bmw = new Auto("BMW", 12000, 2020);
        Auto lada = new Auto("Lada", 12000, 2020);

        Comparator<Auto> autoComparator = new AutoComparator();

        int comparison = autoComparator.compare(mazda, opel);
        if (comparison < 0)
            System.out.println("Mazda");
        else if (comparison > 0)
            System.out.println("Opel");
        else
            System.out.println("Your choice!");

        List<Auto> autos = Arrays.asList(lada, mazda, opel, bmw, mercedes);

        autos.sort(autoComparator);
        System.out.println(autos.toString());
    }
}*/

public class Auto {
    String name;
    double mileage;
    int year;

    public Auto(String name, double mileage, int year) {
        this.name = name;
        this.mileage = mileage;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "name='" + name + '\'' +
                ", mileage=" + mileage +
                ", year=" + year +
                '}';
    }
}

class AutoComparator implements Comparator<Auto> {


    @Override
    public int compare(Auto a1, Auto a2) {
        if (a1.mileage != a2.mileage)
            return (int) (a1.mileage - a2.mileage);

        return a2.year - a1.year;

    }
}

class MileageComparator implements Comparator<Auto> {

    @Override
    public int compare(Auto a1, Auto a2) {
            return (int) (a1.mileage - a2.mileage);
    }
}

class YearComparator implements Comparator<Auto> {

    @Override
    public int compare(Auto a1, Auto a2) {
        return a2.year - a1.year;
    }
}
