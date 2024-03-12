import java.util.*;

public class Implementation {

    public static class MyHashMap<K,V> {
        public static final int DEFAULT_SIZE = 4;
        public static final float DEFAULT_LOAD_FACTOR = 0.75f;

        private class Node {
            K Key;
            V Value;

            Node(K Key, V Value) {
                this.Key = Key;
                this.Value = Value;
            }
        }

        private LinkedList<Node>[] buckets;
        private int n;

        private void initBuckets(int N) {
            buckets = new LinkedList[N];

            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }
        private int hashFunction(K key) {
            int hashCodeValue = key.hashCode();
            return (Math.abs(hashCodeValue)) % buckets.length;
        }
        private int searchLL(LinkedList<Node> ll, K Key) {
            for(int i = 0; i < ll.size(); i++) {
                if(ll.get(i).Key == Key) {
                    return i;
                }
            }

            return -1;
        }
        private void rehash() {
            LinkedList<Node>[] oldBucket = buckets;
            initBuckets(2 * buckets.length);

            n = 0;
            for(var bucket: oldBucket) {
                for(var node: bucket) {
                    put(node.Key, node.Value);
                }
            }
        }

        public int capacity() {
            return buckets.length;
        }
        public float load() {
            return ((n * 1.0f) / buckets.length);
        }

        MyHashMap() {
            initBuckets(DEFAULT_SIZE);
        }

        public int size() {
            return n;
        }

        // Insert & Update
        public void put(K key, V value) {
            int bucketIndex = hashFunction(key);

            LinkedList<Node> currList = buckets[bucketIndex];
            int keyPresent = searchLL(currList, key);

            if(keyPresent == -1) {
                // ADD
                Node node = new Node(key, value);
                currList.add(node);
                n++;
            }
            else {
                // UPDATE
                currList.get(keyPresent).Value = value;
            }

            if( ( (n * 1.0f) / buckets.length) >= 0.75f ) {
                rehash();
            }
        }

        public V get(K Key) {
            int bucketIndex = hashFunction(Key);

            int indexOfBucket = searchLL(buckets[bucketIndex], Key);

            if(indexOfBucket == -1) {
                return null;
            }
            else {
                return buckets[bucketIndex].get(indexOfBucket).Value;
            }
        }

        public V remove(K Key) {
            int bucketIndex = hashFunction(Key);

            int indexOfBucket = searchLL(buckets[bucketIndex], Key);

            if(indexOfBucket == -1) {
                return null;
            }
            else {
                // FOUND
                V valueToReturn = buckets[bucketIndex].get(indexOfBucket).Value;
                buckets[bucketIndex].remove(indexOfBucket);

                n--;

                return valueToReturn;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("a", 1);
        map.put("b", 2);

        System.out.println("Capacity: " + map.capacity());
        System.out.println("Load: " + map.load());

        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);

        System.out.println("Capacity: " + map.capacity());
        System.out.println("Load: " + map.load());

        System.out.println(map.size());
        map.put("c", 30);

        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
        System.out.println(map.get("d"));
        System.out.println(map.get("e"));

        System.out.println(map.remove("c"));
        System.out.println(map.remove("c"));

        System.out.println(map.size());
    }
}
