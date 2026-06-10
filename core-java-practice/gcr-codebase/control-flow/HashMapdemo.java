import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        int arr[] = {1, 22, 31, 22, 1, 5};
        Map<Integer, Integer> count = new HashMap<>();

        for (int a : arr) {
            if (count.containsKey(a)) {
                int ifreq = count.get(a);
                count.put(a, ifreq + 1);
            } else {
                count.put(a, 1);
            }
        }

        for (int a : count.keySet()) {
            System.out.println(a + " ki freq hai ::: " + count.get(a));
        }
    }    
}