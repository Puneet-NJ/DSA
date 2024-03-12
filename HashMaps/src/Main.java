import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("HashMaps");

        // SYNTAX
        Map<String, Integer> mp = new HashMap<>();

        // ADDING ELEMENTS
        mp.put("Akash", 27);
        mp.put("Yash", 19);
        mp.put("Puneet", 21);

        // GET VALUE
        System.out.println(mp.get("Akash"));

        // UPDATING VALUES OR EVEN MAY ADD NEW PAIR
        mp.put("Akash", 25);

        // REMOVING
        System.out.println(mp.remove("Yash"));;
        System.out.println(mp.remove("Riya"));;

        // CHECK IF A KEY IS PRESENT IN HASHMAP
        System.out.println(mp.containsKey("Riya"));
        System.out.println(mp.containsKey("Puneet"));

        // ADD ONLY IF THE KEY DOESN'T EXISTS
        mp.putIfAbsent("Ritika", 21);
        mp.putIfAbsent("Puneet", 29);

        // GET ALL THE KEYS, VALUES AND BOTH
        System.out.println(mp.keySet());
        System.out.println(mp.values());
        System.out.println(mp.entrySet());

        // TRAVERSING OVER THE HASHMAP
        // 1 WAY:
        for(String key: mp.keySet()) {
            System.out.println("Age of " + key +" is "+ mp.get(key));
        }

        System.out.println();
        // 2 WAY:
        for(Map.Entry<String, Integer> e: mp.entrySet()) {
            System.out.println("Age of " + e.getKey() + " is " + e.getValue());
        }

        System.out.println();
        // 3 WAY: AVAILABLE IN JAVA10+
        for(var e: mp.entrySet()) {
            System.out.println("Age of " + e.getKey() + " is " + e.getValue());
        }

        System.out.println(mp.putIfAbsent("kjsad", 23));
    }
}