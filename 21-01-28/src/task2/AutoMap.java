package task2;

import java.util.*;

public class AutoMap {
    private List<Auto> source;

   /* public AutoMap(String make, String color) {
        super(make, color);
    source.add();
    }*/

    public AutoMap(List<Auto> autos) {
        this.source = autos;
    }

    @Override
    public String toString() {
        return "AutoMap{" +
                "source=" + source +
                '}';
    }

    public HashMap<String, List<Auto>> groupByMake(List<Auto> autos) {

            HashMap<String, List<Auto>> autoMap = new HashMap<>();
            HashSet<String> makeSet=new HashSet<>();


            Iterator autoIterator = autos.iterator();
            while (autoIterator.hasNext()){
                Auto res= (Auto) autoIterator.next();
                makeSet.add(res.getMake());
            }

            for (String elm:makeSet) {
                List<Auto> listAuto=new ArrayList<>();
                for (Auto elmAuto:autos) {
                    if (elm.equals(elmAuto.getMake())){
                        listAuto.add(elmAuto);
                    }
                }
                autoMap.put(elm,listAuto);
            }
            return autoMap;
        }


}
