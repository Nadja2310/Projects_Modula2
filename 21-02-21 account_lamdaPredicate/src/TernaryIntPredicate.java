@FunctionalInterface
interface TernaryIntPredicate {
    public boolean test(int a, int b, int c);
}

class TernaryIntPredicateMain {
    public static void main(String[] args)  {
        TernaryIntPredicate myPredicate = (x, y, z) -> x != y && y != z && z != x;
        System.out.println(myPredicate.test(2,3,2));  //false

        System.out.println(myPredicate.test(2,6,9));    //true
    }
}
