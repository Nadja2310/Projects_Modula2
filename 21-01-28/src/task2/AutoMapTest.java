package task2;


import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AutoMapTest {
   List<Auto> listAuto=new ArrayList<>();


    @Test
   void test(){
        List<Auto> listAuto=new ArrayList<>();


        Auto opel = new Auto("Opel","grey");
        Auto opel2 = new Auto("Opel","black");
        Auto mazda = new Auto("Mazda","red" );
        Auto mazda2 = new Auto("Mazda","pink");
        Auto bmw = new Auto("BMW","black");
        Auto audi = new Auto("Audi","blue");
        Auto audi2 = new Auto("Audi","braun");

        listAuto.add(opel);
        listAuto.add(opel2);
        listAuto.add(mazda);
        listAuto.add(mazda2);

        listAuto.add( bmw);
        listAuto.add(audi);
        listAuto.add(audi2);
        Map<String, List<Auto>> autoMap = new HashMap();
        AutoMap groupByMake=new AutoMap(listAuto);
        autoMap=groupByMake.groupByMake(listAuto);

        String[] makeArray={"Audi","Mazda","Opel","BMW"};

        for (String elm:makeArray) {
            assertTrue(autoMap.get(elm)!=null);
        }

       /* Iterator<String> iterator=autoMap.keySet().iterator();
        while (iterator.hasNext()){
            String res=iterator.next();
            System.out.println(res);
        }*/

        for (Map.Entry<String, List<Auto>> element : autoMap.entrySet()) {
            System.out.println(element.getKey());
            System.out.println(element.getValue());

        }
        assertEquals(4,autoMap.size());
    }

}
