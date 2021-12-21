import java.util.HashMap;
import java.util.Map;

public class Dummy {
	static String d;
    public void test() {
        int a;
        a = 2;
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
        map.clear();
        Map<obj, String> map1 = new HashMap<>();
        obj obj1 = new obj (0,"n");
        map1.put(obj1, "OK");
    }
}

class obj {
	int obji = 0;
	String objs = "a";
	public obj(int obj0,String obj1) {
		obji = obj0;
		objs = obj1;
	}
}
