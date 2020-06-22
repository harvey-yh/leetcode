package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/6/22
 * @slogan Drive business with technology, make business generate value.
 */
public class 模式匹配 {
    public boolean patternMatching(String pattern, String value) {
        if (value.isEmpty()) {
            return pattern.length() <= 1;
        }
        if (pattern.isEmpty()) {
            return false;
        }
        int countA = 0, countB = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                countA++;
            } else {
                countB++;
            }
        }
        if (countA == 0 && countB == 0) {
            return value.isEmpty();
        }
        int lenA = 0, lenB = 0, len = value.length();

        if (countA == 0) {
            return value.length() % countB == 0 && matchOnlyOne(value, value.length() / countB);
        } else if (countB == 0) {
            return value.length() % countA == 0 && matchOnlyOne(value, value.length() / countA);
        } else {
            for (; lenA <= len / countA; lenA++) {
                if ((len - countA * lenA) % countB != 0) {
                    continue;
                }
                lenB = (len - countA * lenA) / countB;
                boolean matched = match(pattern, value, lenA, lenB);
                if (matched) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean match(String pattern, String value, int lenA, int lenB) {
        int posA = pattern.indexOf('a'), posB = pattern.indexOf('b');
        String strA = value.substring(posA * lenB, posA * lenB + lenA), strB = value.substring(posB * lenA, posB * lenA + lenB);
        int indexOfValue = 0, indexOfPattern = 0;
        while (indexOfValue < value.length()) {
            char p = pattern.charAt(indexOfPattern++);
            if (p == 'a') {
                for (int j = 0; j < lenA && indexOfValue < value.length(); j++) {
                    if (value.charAt(indexOfValue++) != strA.charAt(j)) {
                        return false;
                    }
                }
            } else {
                for (int j = 0; j < lenB && indexOfValue < value.length(); j++) {
                    if (value.charAt(indexOfValue++) != strB.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean matchOnlyOne(String value, int lenX) {
        String sub = value.substring(0, lenX);
        int indexOfValue = 0;
        for (int i = 0; i < value.length() / lenX; i++) {
            for (int j = 0; j < lenX; j++) {
                if (value.charAt(indexOfValue++) != sub.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
