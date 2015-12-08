package problem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Problem22 {

	public static void main(String[] args) {
		String pathname = "src/main/resources/names.txt"; 
		File file = new File(pathname);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String [] names = br.readLine().split(",");
			
			for( int i=0; i<names.length;i++) {
				names[i] = names[i].substring(1, names[i].length()-1);
			}
			
			Arrays.sort(names);
			
			HashMap<Integer, Integer> nameNumbers = new HashMap<Integer,Integer>();
			
			for( int i=0 ; i<names.length ; i++){
				for( char ch : names[i].toCharArray() ){
					nameNumbers.put(i, get( nameNumbers.get(i) ) + (int)ch-64 );
				}
			}
			
			Integer total = 0;
			for( int j=0 ; j < nameNumbers.size() ; j++){
				total += (j+1) * nameNumbers.get(j);
			}
			
			System.out.println(total);
			
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static int get(Integer integer) {
		int result = 0;
		
		if( integer == null){
			result =0;
		}
		else {
			result = integer;
		}
		
		return result;
	}

}