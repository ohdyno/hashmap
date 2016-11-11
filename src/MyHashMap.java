import java.util.ArrayList;
import java.util.List;

class MyHashMap<Key, Value> {
    private static final int NOT_FOUND_INDEX = -1;
    private static final int DEFAULT_SIZE = 20;
    private int size;
    private List<List<Pair<Key, Value>>> valueLists;

    MyHashMap() {
        valueLists = new ArrayList<>(DEFAULT_SIZE);

        for (int i = 0; i < DEFAULT_SIZE; i++)
            valueLists.add(new ArrayList<>());
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    void insert(Key key, Value value) {
        List<Pair<Key, Value>> values = retrieveMatchedValues(key);
        Pair<Key, Value> pair = getPairWithMatchingKey(key, values);
        if (pair == null) {
            values.add(new Pair<>(key, value));
            size++;
        } else {
            pair.setValue(value);
        }
    }

    Value get(Key key) {
        List<Pair<Key, Value>> values = retrieveMatchedValues(key);
        Pair<Key, Value> pair = getPairWithMatchingKey(key, values);
        if (pair != null)
            return pair.value();
        return null;
    }

    void delete(Key key) {
        List<Pair<Key, Value>> values = retrieveMatchedValues(key);
        int pairIndex = getPairIndexWithMatchingKey(key, values);
        if (pairIndex != NOT_FOUND_INDEX) {
            values.remove(pairIndex);
            size--;
        }
    }

    private int getPairIndexWithMatchingKey(Key key, List<Pair<Key, Value>> values) {
        for (int i = 0; i < values.size(); i++) {
            Pair<Key, Value> pair = values.get(i);
            if (pair.containsKey(key))
                return i;
        }

        return NOT_FOUND_INDEX;
    }

    private Pair<Key, Value> getPairWithMatchingKey(Key key, List<Pair<Key, Value>> values) {
        int pairIndex = getPairIndexWithMatchingKey(key, values);
        if (pairIndex != NOT_FOUND_INDEX)
            return values.get(pairIndex);
        return null;
    }

    private List<Pair<Key, Value>> retrieveMatchedValues(Key key) {
        int index = convertKeyToIndex(key);
        return valueLists.get(index);
    }

    private int convertKeyToIndex(Key key) {
        return Math.abs(key.hashCode()) % valueLists.size();
    }

    private class Pair<K, V> {
        private final K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        boolean containsKey(K key) {
            return key.equals(this.key);
        }

        V value() {
            return value;
        }

        void setValue(V value) {
            this.value = value;
        }
    }
}