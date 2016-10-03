package problem;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem32Test {

    @Test
    public void test() {
        Problem32 p32 = new Problem32Test();
        assertTrue(p32.isPendigital(15234));
    }

}
