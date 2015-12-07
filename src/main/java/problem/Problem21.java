package problem;

import java.util.HashSet;
import java.util.Iterator;

public class Problem21 {
	static HashSet<Integer> numList = new HashSet<Integer>();
	static int firstResult = 0;
	static int secondResult = 0;
	static int lastResult = 0;
	
	public static void main(String[] args) {
		for ( int i=2 ; i<10000 ; i++ ){
			firstResult=d(i);
			secondResult=d(firstResult);
			if( i == secondResult && i != firstResult ){
				System.out.print(i);
				System.out.print("\t");
				System.out.println(firstResult);
				numList.add(i);
				numList.add(firstResult);
			}
		}
		
		Iterator<Integer> it = numList.iterator();
		while( it.hasNext()){
			lastResult+=it.next();
		}
		
		System.out.println("\n"+lastResult);
	}

	private static int d(int i) {
		int result=0;
		
		for(int j=1; j<i ; j++ ){
			if( i%j == 0){
				result+=j;
			}
		}
		return result;
	}
}