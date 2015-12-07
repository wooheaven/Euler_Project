package problem;

public class Problem20 {
	public static void main(String[] args) {
		int[] num = new int [200];
		num[0] = 1;
		int numCount = 1;
		int sum =0;
		
		for(int factorialNum=1; factorialNum<=100;factorialNum++){
			for(int j=0;j<numCount;j++){
				num[j]= num[j]*factorialNum;
			}
			for(int j=0;j<numCount+2;j++){
				while(num[j]>=10){
					num[j+2]+=num[j]/100;
					num[j]=num[j]%100;
					num[j+1]+=num[j]/10;
					num[j]=num[j]%10;
				}
			}
			while((num[0]%10)==0){
				for(int k=0;k<numCount+2;k++){
					num[k]=num[k+1];
				}
			}
			for(int l=num.length-1;l>=0;l--){
				if(num[l]>0){
					numCount=l+1;
					break;
				}
			}
		}
		
		for(int i=0;i<num.length;i++){
			System.out.print(num[num.length-1-i]);
			sum=sum+num[i];
		}
		System.out.println();
		System.out.println(sum);
	}
}
