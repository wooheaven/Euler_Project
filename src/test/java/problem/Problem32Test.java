package problem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Problem32Test {
    private Problem32 p32;
    @Before
    public void setup(){
        p32 = new Problem32();
    }
    
    @Test
    public void test15234_to_true() {
        assertTrue(p32.isPendigital(15234));
    }

    @Test
    public void test15_234_to_true(){
        assertTrue(p32.isPendigital(15,234));
    }
}
