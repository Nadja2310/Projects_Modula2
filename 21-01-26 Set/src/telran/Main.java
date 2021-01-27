package telran;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        OurHashSet<Integer> ourHashSetInt=new OurHashSet<>();


        ourHashSetInt.add(1);
        ourHashSetInt.add(2);
        ourHashSetInt.add(5);
        ourHashSetInt.add(9);
        System.out.println("size"+ourHashSetInt.size());

        ourHashSetInt.remove(2);
        System.out.println("size"+ourHashSetInt.size());

        OurHashSet<Integer> ourHashSet2=new OurHashSet<>();
        ourHashSet2.add(55);
        ourHashSet2.add(25);
        ourHashSet2.add(5);
        ourHashSet2.add(94);
        ourHashSet2.add(21);



        System.out.println("removeAll");
        ourHashSetInt.removeAll(ourHashSet2);
        Iterator<Integer> iteratorRemove=ourHashSetInt.iterator();
        while (iteratorRemove.hasNext()){
            System.out.println(iteratorRemove.next());
        }

        OurHashSet<Integer> ourHashSet3=new OurHashSet<>();
        ourHashSet3.add(55);
        ourHashSet3.add(251);
        ourHashSet3.add(51);
        ourHashSet3.add(94);
        ourHashSet3.add(21);
        ourHashSet3.add(31);

        OurHashSet<Integer> ourHashSet4=new OurHashSet<>();
        ourHashSet4.add(5);
        ourHashSet4.add(251);
        ourHashSet4.add(53);
        ourHashSet4.add(94);
        ourHashSet4.add(20);

        System.out.println("retainAll");

        ourHashSet3.retainAll(ourHashSet4);
//251,94
        Iterator<Integer> iteratorRetain=ourHashSet3.iterator();
        while (iteratorRetain.hasNext()){
            System.out.println(iteratorRetain.next());
        }
    }

}
