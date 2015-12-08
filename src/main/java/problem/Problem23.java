package problem;

import java.util.ArrayList;

public class Problem23 {
	public static void main(String[] args) {

		ArrayList<Integer> abundantNumberTable = new ArrayList<Integer>();

		for (int i = 1; i < 28123; i++) {
			if (isAbundantNumver(i)) {
				abundantNumberTable.add(i);
			}
		}

		long resultSum = (long) 0;

		for (int j = 1; j < 28123; j++) {
			if (!divideByTwoAbundantNumbers(j, abundantNumberTable)) {
				resultSum += j;
			}
		}

		System.out.println(resultSum);
	}

	private static boolean divideByTwoAbundantNumbers(int j, ArrayList<Integer> abundantNumberTable) {
		boolean result = false;

		for (int n = 0; abundantNumberTable.get(n)+abundantNumberTable.get(n) <= j && result == false; n++) {
			for (int m = n; abundantNumberTable.get(m)+abundantNumberTable.get(n) <= j && result==false ; m++) {
				if (abundantNumberTable.get(n) + abundantNumberTable.get(m) == j) {
					result = true;
				}
			}
		}

		return result;
	}

	private static boolean isAbundantNumver(int i) {
		boolean result = false;

		int sum = 0;

		for (int k = 1; k < i; k++) {
			if (i % k == 0) {
				sum += k;
			}
		}

		if (i < sum) {
			result = true;
		}

		return result;
	}
}