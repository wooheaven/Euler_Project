package problem;

import java.util.HashSet;
import java.util.Set;

public class Problem24 {
	public static void main(String[] args) {
		
		int count=10;
		int rank=1000000;
		
		dictionarySort(count,rank);	
		
	}

	private static void dictionarySort(int count, int rank) {
		int [] val = new int[count];
		for(int i=0;i<count;i++){
			val[i]=0;
		}
		
		for(int i=0;i<factorial(count);){
			val[0]++;
			for(int j=0;j<val.length;j++){
				if(val[j]==count){
					val[j]=0;
					val[j+1]++;
				}
			}
			
			Set<Integer> valSet = new HashSet<Integer>();
			for(int j=0;j<val.length;j++){
				valSet.add(val[j]);				
			}
			if(count==valSet.size()){
				i++;
				if(i==rank){
					System.out.print(i+"번째 숫자 = ");
					System.out.println(toNumbers(val));
					System.exit(0);
				}
			}
		}
	}

	private static String toNumbers(int[] val) {
		String result="";
		for(int j=0;j<val.length;j++){
			result=val[j]+result;
		}
		return result;
	}

	private static long factorial(int count) {
		long result=1;
		while(count!=1){
			result=result*count;
			count--;
		}
		return result;
	}
}