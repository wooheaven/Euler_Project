package problem;

import java.util.HashSet;


public class Problem32 {

    public boolean isPendigital(int i) {
        int digitCount = String.valueOf(i).length();
        
        HashSet<Integer> digitNumbers = new HashSet<Integer>();
        while(i%10 > 0){
            digitNumbers.add(i%10);
            i = (i - i%10)/10;
        }
        
        if(digitCount==digitNumbers.size()){
            return true;
        } else {
            return false;
        }
    }
}
