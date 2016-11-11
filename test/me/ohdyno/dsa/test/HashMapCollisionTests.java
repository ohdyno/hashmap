package me.ohdyno.dsa.test;

import me.ohdyno.dsa.main.MyHashMap;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HashMapCollisionTests {

    private static final String VALUE_1 = "value1";
    private static final String VALUE_2 = "value2";
    private final OneHashCodeKey KEY_1 = new OneHashCodeKey();
    private final OneHashCodeKey KEY_2 = new OneHashCodeKey();
    private MyHashMap<OneHashCodeKey, String> map;

    @Before
    public void setUp() {
        map = new MyHashMap<>();
        map.insert(KEY_1, VALUE_1);
        map.insert(KEY_2, VALUE_2);
    }

    @Test
    public void retrieveValue1() throws Exception {
        assertEquals(VALUE_1, map.get(KEY_1));
    }

    @Test
    public void retrieveValue2() throws Exception {
        assertEquals(VALUE_2, map.get(KEY_2));
    }

    @Test
    public void sizeMatchesInsertions() throws Exception {
        assertEquals(2, map.size());
    }

    private class OneHashCodeKey {
        @Override
        public int hashCode() {
            return 0;
        }
    }
}
