package problem;

import java.math.BigInteger;
import java.util.TreeSet;

public class Problem29 {
	public static void main(String[] args) {
		TreeSet<BigInteger> t = new TreeSet<BigInteger>();
		BigInteger num;
		
		for (long a = 2; a < 101; a++) {
			for (int b = 2; b < 101; b++) {
				num=BigInteger.ZERO;
				num=num.add(BigInteger.valueOf(a));
				num=num.pow(b);
				t.add(num);
			}
		}
		
		System.out.println(t.size());
	}
}
