package problem;

import java.util.ArrayList;
import java.util.List;

public class Problem32 {

	public static void main(String[] args) {
		PandigitalNumber mcList = new PandigitalNumber(1);
		mcList.subListOfPowerSet();
		System.out.println(mcList.toString());

		mcList = new PandigitalNumber(2);
		mcList.subListOfPowerSet();
		System.out.println(mcList.toString());
		
		mcList = new PandigitalNumber(3);
		mcList.subListOfPowerSet();
		System.out.println(mcList.toString());
	}
}

class PandigitalNumber
{
	private int digitCount;
	private List<Integer> pandigitalNumberList;
	private int[] initialNumber = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public PandigitalNumber(int count) {
		this.digitCount = count;
		pandigitalNumberList = new ArrayList<Integer>();
	}

	public void subListOfPowerSet() {
		while (0 < digitCount) {
			if (0 == pandigitalNumberList.size()) {
				for (int i = 0; i < initialNumber.length; i++) {
					pandigitalNumberList.add(initialNumber[i]);
				}
			} else {
				List<Integer> tempMultiplicandList = new ArrayList<Integer>();
				for (int i = 0; i < pandigitalNumberList.size(); i++) {
					for (int j = 0; j < initialNumber.length; j++) {
						if (isNumberUnique(pandigitalNumberList.get(i), initialNumber[j])) {
							int tempNum = pandigitalNumberList.get(i) * 10 + initialNumber[j];
							tempMultiplicandList.add(tempNum);
						}
					}
				}
				pandigitalNumberList = tempMultiplicandList;
			}
			digitCount--;
		}
	}

	private boolean isNumberUnique(Integer oldInt, int newInt) {
		boolean result = true;
		int temp = 0;
		while (oldInt > 0) {
			temp = oldInt % 10;
			if (temp == newInt) {
				result = false;
			}
			oldInt = (oldInt - temp) / 10;
		}
		return result;
	}

	public int getDigitCount() {
		return digitCount;
	}

	public void setDigitCount(int digitCount) {
		this.digitCount = digitCount;
	}

	public List<Integer> getMultiplicandList() {
		return pandigitalNumberList;
	}

	public void setMultiplicandList(List<Integer> multiplicandList) {
		this.pandigitalNumberList = multiplicandList;
	}

	public int[] getNumberList() {
		return initialNumber;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("MultiplicandList\n");
		for (int i = 0; i < pandigitalNumberList.size(); i++) {
			sb.append(i + 1 + "번째 원소");
			sb.append("\t=\t");
			sb.append(pandigitalNumberList.get(i));
			sb.append("\n");
		}
		return sb.toString();
	}
}