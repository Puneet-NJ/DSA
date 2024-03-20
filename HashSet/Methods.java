import java.util.*;

public class Methods {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Riya");
        set.add("Nikhil");

        System.out.println(set); //["Riya", "Nikhil"]

        System.out.println(set.remove("Nikhil")); // true
        System.out.println(set.remove("Travis")); // false

        System.out.println(set.contains("Riya")); // true
        System.out.println(set.contains("Punnet")); // false

        set.add("Puneet");
        System.out.println(set.size()); // 2

        // Iterating over the Set
        for(String s: set) {
            System.out.println(s);
        }
    }
}
