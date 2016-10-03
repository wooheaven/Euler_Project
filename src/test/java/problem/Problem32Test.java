package problem;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem32Test {

    @Test
    public void test15234_to_true() {
        Problem32 p32 = new Problem32();
        assertTrue(p32.isPendigital(15234));
    }

    @Test
    public void test15_234_to_true(){
        Problem32 p32 = new Problem32();
        assertTrue(p32.isPendigital(15,234));
    }
}
