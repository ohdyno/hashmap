package me.ohdyno.dsa.test;

import me.ohdyno.dsa.main.MyHashMap;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class EmptyHashMapTests {

    private MyHashMap<String, String> map;

    @Before
    public void setUp() {
        map = new MyHashMap<>();
    }

    @Test
    public void newMapShouldBeEmpty() {
        assertTrue(map.isEmpty());
    }

    @Test
    public void newMapShouldHaveZeroSize() throws Exception {
        assertEquals(0, map.size());
    }

    @Test
    public void shouldOnlyRetrieveNullFromNewMap() throws Exception {
        assertNull(map.get("unknown"));
    }
}
