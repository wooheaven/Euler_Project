package problem;

import java.util.HashMap;
import java.util.HashSet;


public class Problem32 {
    private HashSet<Integer> notPendigitalNumbers = new HashSet<Integer>();
    private HashMap<Integer, String> pendigitalNumbers = new HashMap<Integer, String>();

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

        if (digitCount == digitNumbers.size() && digitCount == 9) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNinePendigitalProduct(int i, int j) {
        int product = i * j;
        if (notPendigitalNumbers.contains(i) || notPendigitalNumbers.contains(j) || notPendigitalNumbers.contains(product)) {
            return false;
        } else if (isNinePendigital(i, j, product)) {
            pendigitalNumbers.put(pendigitalNumbers.size(), i + " * " + j + " = " + product);
            System.out.println(i + " * " + j + " = " + product);
            System.out.println(pendigitalNumbers.get(pendigitalNumbers.size()-1));
            return true;
        } else {
            if (!isNinePendigital(i)) {
                notPendigitalNumbers.add(i);
            }
            if (!isNinePendigital(j)) {
                notPendigitalNumbers.add(j);
            }
            if (!isNinePendigital(product)) {
                notPendigitalNumbers.add(product);
            }
            return false;
        }
    }
}
