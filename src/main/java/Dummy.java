import visitor.VisiterForTutorial;

import java.util.HashMap;
import java.util.Map;

public class Dummy {
    public void test() {
        int a = 2;
        final int c = 1;
        if (a == 2) {
            System.out.println("1-1");
            if(a < 3){
                System.out.println("1-2");
            }
        }
        int b = 1;
        
        Map<Integer, String> map = new HashMap<>();
        map.put(a, "a");
        map.put(b, "b");
        System.out.println(map.get(c));
    }
}
