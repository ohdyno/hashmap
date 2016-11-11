import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class HashMapOverwriteInsertionsTests {

    private static final String KEY = "key";
    private static final String VALUE = "value";
    private static final String VALUE_2 = "value2";
    private MyHashMap<String, String> map;
    private int originalSize;

    @Before
    public void setUp() {
        map = new MyHashMap<>();
        map.insert(KEY, VALUE);
        originalSize = map.size();
        map.insert(KEY, VALUE_2);
    }

    @Test
    public void sizeRemainsTheSame() throws Exception {
        assertEquals(originalSize, map.size());
    }

    @Test
    public void retrieveNewValue() throws Exception {
        assertEquals(VALUE_2, map.get(KEY));
    }

    @Test
    public void retrieveAfterDeletion() throws Exception {
        map.delete(KEY);
        assertNull(map.get(KEY));
    }
}
