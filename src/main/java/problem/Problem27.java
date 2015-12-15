package problem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Problem27 {
	public static void main(String[] args) {
		HashMap<Integer, String> map1 = new HashMap<Integer, String>();

		for (int a = -1000; a < 1001; a++) {
			for (int b = -1000; b < 1001; b++) {
				// System.out.printf("%5d, %5d, n^2+(%5d)n+(%5d),", a, b, a, b);
				// System.out.printf("%5d, %5d, n^2+(%5d)n+(%5d),\n", a, b, a,
				// b);
				boolean flag = true;
				int n = 0;
				while (flag == true) {
					flag = isPrime(n, a, b);
					if (flag == true) {
						n++;
					}
				}
				// System.out.printf("%5d\n", n);
				map1.put(n, String.valueOf(a) + "," + String.valueOf(b));
			}
		}
		/*
		 * System.out.println(map1);
		 * 
		 * Set<Entry<Integer, String>> set1=map1.entrySet();
		 * Iterator<Entry<Integer, String>> itr1=set1.iterator();
		 * while(itr1.hasNext()){ Map.Entry entry1=(Entry)itr1.next();
		 * System.out.print(entry1.getKey() + ": ");
		 * System.out.println(entry1.getValue()); }
		 */

		Map<Integer, String> map2 = new TreeMap<Integer, String>(map1);
		Set<Entry<Integer, String>> set2 = map2.entrySet();
		Iterator<Entry<Integer, String>> itr2 = set2.iterator();
		while (itr2.hasNext()) {
			Map.Entry entry2 = (Entry) itr2.next();
			System.out.print(entry2.getKey() + ": ");
			System.out.println(entry2.getValue());
		}
	}

	private static boolean isPrime(int n, int a, int b) {
		boolean result = true;
		int targetNum = n * n + a * n + b;

		if (targetNum < 0) {
			targetNum = targetNum * -1;
		} else if (targetNum == 0) {
			result = false;
		}

		for (int m = 2; m < targetNum && result == true; m++) {
			if (targetNum % m == 0) {
				result = false;
			}
		}
		return result;
	}
}
