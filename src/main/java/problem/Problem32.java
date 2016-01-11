package problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem32 {

	public static void main(String[] args) {
		UniqNumber un1 = new UniqNumber(1);
		un1.subListOfPowerSet();
		System.out.println(un1);

		UniqNumber un2 = new UniqNumber(2);
		un2.subListOfPowerSet();
		System.out.println(un2);

		UniqNumber un3 = new UniqNumber(3);
		un3.subListOfPowerSet();
		System.out.println(un3);

		UniqNumber un4 = new UniqNumber(4);
		un4.subListOfPowerSet();
		System.out.println(un4);

		UniqNumber un5 = new UniqNumber(5);
		un5.subListOfPowerSet();
		System.out.println(un5);

		UniqNumber un6 = new UniqNumber(6);
		un6.subListOfPowerSet();
		System.out.println(un6);

		UniqNumber un7 = new UniqNumber(7);
		un7.subListOfPowerSet();
		System.out.println(un7);

		List<UniqNumber> unList = new ArrayList<UniqNumber>();
		unList.add(un1);
		unList.add(un2);
		unList.add(un3);
		unList.add(un4);
		unList.add(un5);
		unList.add(un6);
		unList.add(un7);

		// uniq multiple by un1 and unList

	}
}

class UniqNumber {
	private int digitCount;
	private List<Integer> uniqNumberList;
	private int[] initialNumber = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public UniqNumber(int count) {
		this.digitCount = count;
		uniqNumberList = new ArrayList<Integer>();
	}

	public void subListOfPowerSet() {
		while (0 < digitCount) {
			if (0 == uniqNumberList.size()) {
				for (int i = 0; i < initialNumber.length; i++) {
					uniqNumberList.add(initialNumber[i]);
				}
			} else {
				List<Integer> tempMultiplicandList = new ArrayList<Integer>();
				for (int i = 0; i < uniqNumberList.size(); i++) {
					for (int j = 0; j < initialNumber.length; j++) {
						if (isNumberUnique(uniqNumberList.get(i), initialNumber[j])) {
							int tempNum = uniqNumberList.get(i) * 10 + initialNumber[j];
							tempMultiplicandList.add(tempNum);
						}
					}
				}
				uniqNumberList = tempMultiplicandList;
			}
			digitCount--;
		}
	}

	private boolean isNumberUnique(Integer oldInt, int newInt) {
		boolean result = true;
		int temp = 0;
		int intSize = 0;
		Set<Integer> numberSet = new HashSet<Integer>();
		while (oldInt > 0) {
			temp = oldInt % 10;
			numberSet.add(temp);
			oldInt=(oldInt-temp)/10;
			intSize++;
		}
		while (newInt > 0){
			temp = newInt % 10;
			numberSet.add(temp);
			newInt=(newInt-temp)/10;
			intSize++;
		}
		if(intSize != numberSet.size()){
			result = false;
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("MultiplicandList\n");
		for (int i = 0; i < uniqNumberList.size(); i++) {
			sb.append(i + 1 + "번째 원소");
			sb.append("\t=\t");
			sb.append(uniqNumberList.get(i));
			sb.append("\n");
		}
		return sb.toString();
	}
}