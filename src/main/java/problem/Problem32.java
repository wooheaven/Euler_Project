package problem;

import java.util.ArrayList;
import java.util.List;

public class Problem32 {

	public static void main(String[] args) {
		NumList numList = new NumList();
		System.out.println(numList.toString());

		MultiplicandList mcList = new MultiplicandList(1);
		mcList.makeList(numList);
		System.out.println(mcList.toString());
		
		mcList = new MultiplicandList(2);
		mcList.makeList(numList);
		System.out.println(mcList.toString());
	}
}

class NumList {
	private List<Integer> numList = null;

	public NumList() {
		numList = new ArrayList<Integer>(9);
		for (int i = 1; i < 10; i++) {
			numList.add(i);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("NumList\n");
		for (int i = 0; i < numList.size(); i++) {
			sb.append(i);
			sb.append("\t");
			sb.append(numList.get(i));
			sb.append("\n");
		}
		return sb.toString();
	}

	public int[] getIntegerArray() {
		int[] result = new int[numList.size()];
		for (int i = 0; i < numList.size(); i++) {
			result[i] = (int) numList.get(i);
		}
		return result;
	}
}

class MultiplicandList {
	private int digitCount;
	private List<Integer> multiplicandList = null;

	public MultiplicandList(int count) {
		this.digitCount = count;
		multiplicandList = new ArrayList<Integer>();
	}

	public void makeList(NumList numList) {
		int[] input = numList.getIntegerArray();
		if (1 == getCount()) {
			for (int i = 0; i < input.length; i++) {
				multiplicandList.add(input[i]);
			}
		} else if (getCount() >= 2) {

		}
	}

	public int getCount() {
		return digitCount;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("MultiplicandList\n");
		for (int i = 0; i < multiplicandList.size(); i++) {
			sb.append(i);
			sb.append("\t");
			sb.append(multiplicandList.get(i));
			sb.append("\n");
		}
		return sb.toString();
	}
}