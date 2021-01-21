package telran;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        OurHashMap<Auto, String> map = new OurHashMap<>();
        filMap(map);
        Auto opel = new Auto("grey", "Opel");
        Auto mazda = new Auto("red", "Mazda");
        Auto bmw = new Auto("black", "BMW");
        Auto another = new Auto("blue", "Audi");

        String value=map.get(another);
        System.out.println(value);

    }

    static void filMap(OurHashMap<Auto, String> map) {
        Auto greyOpel = new Auto("grey", "Opel");
        map.put(greyOpel, "Value of grey opel");

    }
}

class Auto {
    private final String make;
    private final String color;

    public Auto(String make, String color) {
        this.make = make;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(make, auto.make) &&
                Objects.equals(color, auto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, color);
    }


}