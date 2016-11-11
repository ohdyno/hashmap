package me.ohdyno.dsa.test;

import me.ohdyno.dsa.main.MyHashMap;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class HashMapDeletionTests {

    private static final String KEY = "key";
    private static final String VALUE = "value";
    private static final String KEY_2 = "key2";
    private static final String VALUE_2 = "value2";
    private MyHashMap<String, String> map;

    @Before
    public void setUp() {
        map = new MyHashMap<>();
        map.insert(KEY, VALUE);
        map.insert(KEY_2, VALUE_2);
        map.delete(KEY);
    }

    @Test
    public void retrieveDeletedKey() throws Exception {
        assertNull(map.get(KEY));
    }

    @Test
    public void retrieveExistingKey() throws Exception {
        assertEquals(VALUE_2, map.get(KEY_2));
    }

    @Test
    public void sizeShouldDecrease() throws Exception {
        assertEquals(1, map.size());
    }
}
