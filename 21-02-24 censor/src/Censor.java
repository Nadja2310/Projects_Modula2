//Задачи. На первые три задачи надо просто посмотреть и сказать, чему будет равен результат:
//1.
//boolean result = LongStream.rangeClosed(1, 100_000)
//        .anyMatch(val -> val == 100_000);
//   res=100_000

//2.
//boolean result = IntStream.generate(() -> 100)
//        .limit(101)
//        .allMatch(val -> val >= 100);
//Будет 101 элемент со значанием 100 [100,100,.......,100] и все они удовлетворяют условию. res=true

//3.
//boolean result = IntStream.iterate(0, n -> n + 1)
//        .limit(100)
//        .filter(n -> n % 2 != 0)
//        .noneMatch(n -> n % 2 == 0);
//от 1 до 99 все нечетные числа [1,3,5,7,9,11,13,15,17,19,21,23,...89,91,93,95,97,99];все элементы не делятся на 2
//без остатка
//res=true
//4.
//Есть класс Censor, у которого есть поле 'private Set<String> dictionary' со словами,
// которые считаются плохими. Это поле инициализируется через конструктор, после чего неизменно.
// Также класс имеет публичный метод 'public bollean verify(String text)'.
// Этот метод проверяет текст на цензуру.
// Известно, что текст содержит только слова, разделенные пробелами. Ничего более в тексте нет.
// Написать и протестировать (edited)

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

public class Censor {
    private final Set<String> dictionary;

    public Censor(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public boolean verify(String text) {
        Stream<String> stringStream = Arrays.stream(text.split(" "));

        return stringStream.noneMatch(str -> dictionary.contains(str));
    }
}
