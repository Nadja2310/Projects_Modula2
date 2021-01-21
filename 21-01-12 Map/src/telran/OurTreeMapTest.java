package telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OurTreeMapTest extends OurMapTest{

    @BeforeEach
    public void init(){
        map = new OurTreeMap<>();
        intMap=new OurTreeMap<>();
    }
    @Test
    void testRemove_twoObjectInCells_UpElement2() {

        Auto opel = new Auto("grey", "Opel");
        Auto mazda = new Auto("red", "Mazda");
        Auto bmw = new Auto("black", "BMW");
        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN4528", opel);
        map.put("WIN74528", opel);
        map.put("WIN56828", mazda);
        map.put("WIN56628", mazda);
        map.put("WIN56298", mazda);
        map.put("WIN8988", bmw);
        map.put("WIN8989", bmw);
        map.put("WIN5628", audi);
        map.put("WIN56256", audi2);
        assertEquals(opel,map.remove("WIN74528"));
//        assertEquals(map.get("WIN74528"), bmw);
        assertEquals(8,map.size());

        String[] autoWin={"WIN4528","WIN56828","WIN56628","WIN56298","WIN8988","WIN8989","WIN5628","WIN56256"};
        checkAllElements(map,autoWin);
    }
}