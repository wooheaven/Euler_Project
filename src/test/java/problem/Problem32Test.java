package problem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Problem32Test {
	private Problem32 p32;

	@Before
	public void setup() {
		p32 = new Problem32();
	}

	@Test
	public void test_15234_is_uniq() {
		assertTrue(p32.isUniqNumbers(15234));
	}

	@Test
	public void test_15_234_are_uniq() {
		assertTrue(p32.isUniqNumbers(15, 234));
	}

	@Test
	public void test_15_23_4_are_uniq() {
		assertTrue(p32.isUniqNumbers(15, 23, 4));
	}

	@Test
	public void test_152346789_is_9pendigital() {
		assertTrue(p32.isNinePendigital(152346789));
	}

	@Test
	public void test_15_2346789_is_9pendigital() {
		assertTrue(p32.isNinePendigital(15, 2346789));
	}

	@Test
	public void test_15_23_46789_is_9pendigital() {
		assertTrue(p32.isNinePendigital(15, 23, 46789));
	}
}