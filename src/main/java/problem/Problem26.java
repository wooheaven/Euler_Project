package problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Problem26 {
	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();

		int numerator = 1;

		Set<Integer> lengthSet = new HashSet<Integer>();

		for (int denominator = 2; denominator < 1001; denominator++) {
			ArrayList<Integer> recurringCycle = new ArrayList<Integer>();

			if (checkRecurringCycle(denominator)) {
				 System.out.printf("%d/%4d = %d : recurringCycle's length = 0\n", numerator, denominator, numerator / denominator);
			} else {
				recurringCycle = makeRecurringCycle(numerator, denominator, recurringCycle);
				System.out.printf("%d/%4d = %.20f : recurringCycle's length =%3d, ", numerator, denominator, ((double) numerator) / (double) denominator, recurringCycle.size());
				System.out.println(recurringCycle);
				lengthSet.add(recurringCycle.size());
			}
		}

		List<Integer> lengthList = new ArrayList<Integer>(lengthSet);
		Collections.sort(lengthList);
		System.out.printf("\nrecurringCycle's longest cycle length = ");
		
		System.out.println(lengthList.get(lengthList.size()-1));
		
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("took " + estimatedTime + " ms");
	}

	private static ArrayList<Integer> makeRecurringCycle(int numerator, int denominator, ArrayList<Integer> recurringCycle) {
		boolean endRecurringCycle = false;
		Set<Integer> remainderSet = new HashSet<Integer>();
		int quotient;
		while (endRecurringCycle == false) {
			if (numerator < denominator) {
				numerator = numerator * 10;
			}
			if (numerator > denominator) {
				quotient = numerator / denominator;
				numerator = numerator % denominator;
				if (remainderSet.contains(numerator)) {
					endRecurringCycle = true;
				} else {
					remainderSet.add(numerator);
					recurringCycle.add(quotient);
				}
			} else {
				quotient = 0;
				if (remainderSet.contains(numerator)) {
					endRecurringCycle = true;
				} else {
					remainderSet.add(numerator);
					recurringCycle.add(quotient);
				}
			}
		}
		return recurringCycle;
	}

	private static boolean checkRecurringCycle(int y) {
		boolean result = false;

		while (y % 5 == 0) {
			y = y / 5;
		}

		while (y % 2 == 0) {
			y = y / 2;
		}

		if (y == 1) {
			result = true;
		}

		return result;
	}
}