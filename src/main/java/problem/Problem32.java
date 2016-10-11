package problem;

import java.util.HashMap;
import java.util.HashSet;


public class Problem32 {
    private HashSet<Integer> notUniqNumberSet = new HashSet<Integer>();
    private HashMap<String, String> pendigitalNumberHashMap = new HashMap<String, String>();
    private HashMap<String, String> notPendigitalNumberHashMap = new HashMap<String, String>();

    private boolean isNinePendigital(int i, int j, int k) {
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

    private boolean isUniq(int i) {
        int digiCount = String.valueOf(i).length();

        HashSet<Integer> digitNumbers = new HashSet<Integer>();
        int tmpInt = i;
        while (tmpInt % 10 > 0) {
            digitNumbers.add(tmpInt % 10);
            tmpInt = (tmpInt - tmpInt % 10) / 10;
        }

        return digiCount == digitNumbers.size();
    }

    public boolean isNinePendigitalProduct(int i, int j) {
        if (i > j) {
            int tmp = i;
            i = j;
            j = tmp;
        }

        int product = i * j;
        String key = i + "," + j;

        if (!isUniq(i)) {
            notUniqNumberSet.add(i);
        }
        if (!isUniq(j)) {
            notUniqNumberSet.add(j);
        }

        if (notUniqNumberSet.contains(i) || notUniqNumberSet.contains(j)) {
            return false;
        } else if (pendigitalNumberHashMap.containsKey(key)) {
            return true;
        } else if (notPendigitalNumberHashMap.containsKey(key)) {
            return false;
        } else if (isNinePendigital(i, j, product)) {
            pendigitalNumberHashMap.put(key, i + " * " + j + " = " + product);
            return true;
        } else {
            notPendigitalNumberHashMap.put(key, i + " * " + j + " = " + product);
            return false;
        }
    }

    public HashMap<String, String> getPendigitalNumberHashMap() {
        return pendigitalNumberHashMap;
    }
}
