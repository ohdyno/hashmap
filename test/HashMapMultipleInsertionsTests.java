import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HashMapMultipleInsertionsTests {

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
    }

    @Test
    public void retrieveValue1() throws Exception {
        assertEquals(VALUE, map.get(KEY));
    }

    @Test
    public void retrieveValue2() throws Exception {
        assertEquals(VALUE_2, map.get(KEY_2));
    }

    @Test
    public void sizeMatchInsertions() throws Exception {
        assertEquals(2, map.size());
    }
}
