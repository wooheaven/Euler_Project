package problem;

import java.util.HashSet;
import java.util.Iterator;

public class Problem30 {
	public static void main(String[] args) {
		long numA = 0;
		long numB = 0;
		HashSet<Long> s = new HashSet<Long>();

		for (int a = 0; a < 10; a++) {
			for (int b = 0; b < 10; b++) {
				for (int c = 0; c < 10; c++) {
					for (int d = 0; d < 10; d++) {
						for (int e = 0; e < 10; e++) {
							for (int f = 0; f < 10; f++) {
								numA = leftNum(a, b, c, d, e, f);
								numB = rightNum(a, b, c, d, e, f);

								if (numA == numB) {
									s.add(Long.valueOf(numA));
								} else if (numA < numB) {
									break;
								}
							}
						}
					}
				}
			}
		}

		long sum = 0;
		for (Iterator iterator = s.iterator(); iterator.hasNext();) {
			Long long1 = (Long) iterator.next();
			sum = sum + long1.longValue();
		}

		System.out.println(sum - 1);
	}
	private static long rightNum(int a, int b, int c, int d, int e, int f) {
		return a * a * a * a * a + b * b * b * b * b + c * c * c * c * c + d
				* d * d * d * d + e * e * e * e * e + f * f * f * f * f;
	}

	private static long leftNum(int a, int b, int c, int d, int e, int f) {
		return a * 100000 + b * 10000 + c * 1000 + d * 100 + e * 10 + f;
	}
}
