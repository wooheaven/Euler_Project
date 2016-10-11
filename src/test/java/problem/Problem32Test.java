package problem;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Problem32Test {
    private Problem32 p32;

    @Before
    public void setup() {
        p32 = new Problem32();
    }

    @Test
    public void test_39_186_is_9pendigitalProduct() {
        assertTrue(p32.isNinePendigitalProduct(39, 186));
        assertTrue(p32.isNinePendigitalProduct(186, 39));
    }

    @Test
    public void test_39_187_isNot_9pendigitalProduct() {
        assertFalse(p32.isNinePendigitalProduct(39, 187));
        assertFalse(p32.isNinePendigitalProduct(187, 39));
    }

    @Test
    public void test_1_to_999999999_1_to_999999999_find_9pendigitalProduct() {
        for (int i = 2; i < 999999999; i++) {
            for (int j = i + 1; j < 500000000 && i * j < 987654321; j++) {
                p32.isNinePendigitalProduct(i, j);
            }
        }

        for (String key : p32.getPendigitalNumberHashMap().keySet()) {
            HashMap<String, String> result = p32.getPendigitalNumberHashMap();
            System.out.println(key + "," + result.get(key));
        }
    }
}