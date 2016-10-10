package problem;

import java.util.HashSet;


public class Problem32 {
    public boolean isNinePendigital(int i) {
        int[] intArray = new int[1];
        intArray[0] = i;

        return isNinePendigital(intArray);
    }

    public boolean isNinePendigital(int i, int j) {
        int[] intArray = new int[2];
        intArray[0] = i;
        intArray[1] = j;

        return isNinePendigital(intArray);
    }

    public boolean isNinePendigital(int i, int j, int k) {
        int[] intArray = new int[3];
        intArray[0] = i;
        intArray[1] = j;
        intArray[2] = k;

        return isNinePendigital(intArray);
    }

    private boolean isNinePendigital(int[] intArray) {
        int digitCount = 0;
        for (int i = 0; i < intArray.length; i++) {
            digitCount += String.valueOf(intArray[i]).length();
        }

        HashSet<Integer> digitNumbers = new HashSet<Integer>();
        for (int i = 0; i < intArray.length; i++) {
            int tmpInt = intArray[i];
            while (tmpInt % 10 > 0) {
                digitNumbers.add(tmpInt % 10);
                tmpInt = (tmpInt - tmpInt % 10) / 10;
            }
        }

        if(digitCount==digitNumbers.size() && digitCount == 9){
            return true;
        } else {
            return false;
        }
    }
}
