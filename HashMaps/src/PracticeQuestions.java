import java.util.*;

public class PracticeQuestions {
    public static void main(String[] args) {
        // FIND THE ELEMENT WITH MOST FREQUENCY
        int[] arr = {1,4,2,1,1,3,2,2,2,2};

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            }
            else {
                map.put(arr[i], 1);
            }
        }

        int mostOccurredIndex = -1;
        int mostOccurredEle = -1;

        for(var e: map.entrySet()) {
            if(mostOccurredEle < e.getValue()) {
                mostOccurredIndex = e.getKey();
                mostOccurredEle = e.getValue();
            }
        }
        System.out.println(mostOccurredIndex);
    }
}
