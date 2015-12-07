package problem;

import java.util.Calendar;

public class Problem19 {
	public static void main(String[] args) {
		int sum = 0;
		Calendar timeData = Calendar.getInstance();
		timeData.set(1901, 0, 1);
		while (timeData.get(Calendar.YEAR) < 2001) {
			if (timeData.get(Calendar.DATE) == 1
					&& timeData.get(Calendar.DAY_OF_WEEK) == 1) {
				sum++;
				System.out.println(sum + "\t" + timeData.getTime());
			}
			timeData.add(Calendar.DATE, 1);
		}
	}
}
