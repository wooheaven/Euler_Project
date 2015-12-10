package problem;

import java.math.BigInteger;

public class Problem25 {
	public static void main(String[] args) {
		
		BigInteger Num[] = {BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO};
		int count=2;
				
		while(Num[2].toString().length()<1000){
			count++;
			Num[2]=Num[1].add(Num[0]);
			Num[0]=Num[1];
			Num[1]=Num[2];	
		}
						
		System.out.println("[ "+count+" ] = "+ Num[2] );
		System.out.println("[ "+count+" ]'s length = "+ Num[2].toString().length() );
	}
}
