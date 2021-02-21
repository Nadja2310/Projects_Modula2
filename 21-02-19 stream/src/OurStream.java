import java.util.Arrays;
import java.util.Collection;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class OurStream {

    public boolean isPrime(int number){
        return IntStream.range(2,number).filter(div -> number % div == 0).allMatch(sumDiv->sumDiv==1);
    }

    public int sumOdd(int a, int b){
        //Stream.iterate(1, n -> n < 20 , n -> n * 2)) c 9 Java
        return IntStream.iterate(a,x->x<=b,x->x+1).filter(element->element%2!=0).sum();
    }

    public int factorial(int a){

        return IntStream.iterate(1,x->x+1).limit(a)
                .reduce((s1,s2)->s1+s2).orElse(1);
    }
    public int[] streamElementsAreDividedInto3und5(int a, int b){
        IntStream eventStream = IntStream.iterate(a,x->x<=b,x->x+1).filter(element->element%2==0);
        IntStream oddStream = IntStream.iterate(a,x->x<=b,x->x+1).filter(element->element%2!=0);
        return  IntStream.concat(eventStream, oddStream).filter(element->element%3==0 && element%5==0)
        .sorted().skip(2).toArray();
    }
}
