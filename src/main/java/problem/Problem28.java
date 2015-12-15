package problem;

import java.util.HashMap;

public class Problem28 {
	public static void main(String[] args) {
		HashMap<Integer, Integer> oneSequence = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> fiveSequence = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> sevenSequence = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> elevenSequence = new HashMap<Integer, Integer>();
		
		oneSequence.put(1, 9);
		fiveSequence.put(1, 3);
		sevenSequence.put(1, 5);
		elevenSequence.put(1, 7);
		
		int gap = 2;
		
		for (int i = 2; i <= 501; i++) {
			gap=gap+2;
			fiveSequence.put(i,gap+oneSequence.get(i-1));
			sevenSequence.put(i, gap+fiveSequence.get(i));
			elevenSequence.put(i, gap+sevenSequence.get(i));
			oneSequence.put(i, gap+elevenSequence.get(i));
			
		}
		
//		System.out.println(oneSequence);
//		System.out.println(fiveSequence);
//		System.out.println(sevenSequence);
//		System.out.println(elevenSequence);
//		System.out.println(oneSequence.size());
//		System.out.println(fiveSequence.size());
//		System.out.println(sevenSequence.size());
//		System.out.println(elevenSequence.size());
		
		int sum = 1;
		
		for (int i = 1; i < oneSequence.size(); i++) {
			sum=sum+oneSequence.get(i);
			sum=sum+fiveSequence.get(i);
			sum=sum+sevenSequence.get(i);
			sum=sum+elevenSequence.get(i);
		}
		
		System.out.printf("sum of the numbers on the diagonals in a 1001 by 1001 = %d",sum);
	}
}
