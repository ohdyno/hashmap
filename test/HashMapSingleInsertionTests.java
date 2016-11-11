import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class HashMapSingleInsertionTests {

    private static final String KEY = "key";
    private static final String VALUE = "value";
    private MyHashMap<String, String> map;

    @Before
    public void setUp() {
        map = new MyHashMap<>();
        map.insert(KEY, VALUE);
    }

    @Test
    public void mapIsNotEmpty() throws Exception {
        assertFalse(map.isEmpty());
    }

    @Test
    public void mapSizeHasIncreased() throws Exception {
        assertEquals(1, map.size());
    }

    @Test
    public void retrieveValueFromMap() throws Exception {
        assertEquals(VALUE, map.get(KEY));
    }

    @Test
    public void retrieveNonExistentKeyFromMap() throws Exception {
        assertNull(map.get("unknown"));
    }
}
