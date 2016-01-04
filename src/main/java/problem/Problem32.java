package problem;

import java.util.ArrayList;
import java.util.List;

public class Problem32 {

	public static void main(String[] args) {
		MultiplicandList mcList = new MultiplicandList(1);
		mcList.subListOfPowerSet();
		System.out.println(mcList.toString());

		mcList = new MultiplicandList(2);
		mcList.subListOfPowerSet();
		System.out.println(mcList.toString());
	}
}

class MultiplicandList {
	private int digitCount;
	private List<Integer> multiplicandList;
	private int[] numberList = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public MultiplicandList(int count) {
		this.digitCount = count;
		multiplicandList = new ArrayList<Integer>();
	}

	public void subListOfPowerSet() {
		while (1 <= digitCount) {
			if (0 == multiplicandList.size()) {
				for (int i = 0; i < numberList.length; i++) {
					multiplicandList.add(numberList[i]);
				}
			} else {
				List<Integer> tempMultiplicandList = new ArrayList<Integer>();
				for (int i = 0; i < multiplicandList.size(); i++) {
					for (int j = 0; j < numberList.length; j++) {
						if (multiplicandList.get(i) != numberList[j]) {
							int tempNum = multiplicandList.get(i) * 10 + numberList[j];
							tempMultiplicandList.add(tempNum);
						}
					}
				}
				multiplicandList = tempMultiplicandList;
			}
			digitCount--;
		}
	}

	public int getDigitCount() {
		return digitCount;
	}

	public void setDigitCount(int digitCount) {
		this.digitCount = digitCount;
	}

	public List<Integer> getMultiplicandList() {
		return multiplicandList;
	}

	public void setMultiplicandList(List<Integer> multiplicandList) {
		this.multiplicandList = multiplicandList;
	}

	public int[] getNumberList() {
		return numberList;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("MultiplicandList\n");
		for (int i = 0; i < multiplicandList.size(); i++) {
			sb.append(i+1 + "번째 원소");
			sb.append("\t=\t");
			sb.append(multiplicandList.get(i));
			sb.append("\n");
		}
		return sb.toString();
	}
}