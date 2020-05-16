package at.madlmayr.kata01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestStringFinder {

    public String findSubString(final String inputString) {

        if (inputString.length() < 2) {
            return "";
        }

        int startIndex = -1;
        int endIndex = -1;
        int firstOccurenceOfSecondChar = -1;
        char char1 = ' ';
        char char2 = ' ';

        for (int indexCounter = 0; indexCounter < inputString.length(); indexCounter++) {

            // init with first run-thru
            if (startIndex == -1) {
                startIndex = indexCounter;
                char1 = inputString.charAt(indexCounter);
            }

            // this is our char1
            if (char1 == ' ') {
                char1 = inputString.charAt(indexCounter);
                startIndex = indexCounter;
            }
            // if the second char is empty, put our char there, set endindex.
            else if (char2 == ' ' && char1 != inputString.charAt(indexCounter)) {
                char2 = inputString.charAt(indexCounter);
                endIndex = indexCounter;
                firstOccurenceOfSecondChar = indexCounter;
            }
            // in case we know the character, just increment the end counter.
            else if (char1 == inputString.charAt(indexCounter) || char2 == inputString.charAt(indexCounter)) {
                endIndex = indexCounter;
            }
            // in this case we have a 3rd char.
            // in our case we chose a recursive solution.
            else {
                String result = findSubString(inputString.substring(firstOccurenceOfSecondChar));
                if (result.length() >= (endIndex + 1) - startIndex)
                    return result;
                else
                    return inputString.substring(startIndex, endIndex + 1);
            }
        }
        return inputString.substring(startIndex, endIndex + 1);
    }


    @Test
    public void testWith1Char() {
        assertEquals(findSubString("a"), "");
    }

    @Test
    public void testWith2CharsUnequal() {
        assertEquals(findSubString("ab"), "ab");
    }

    @Test
    public void testWith3CharsUnequalABB() {
        assertEquals(findSubString("abb"), "abb");
    }

    @Test
    public void testWith3CharsUnequalBAB() {
        assertEquals(findSubString("bab"), "bab");
    }

    @Test
    public void testWith3CharsUnequalAAB() {
        assertEquals(findSubString("aab"), "aab");
    }

    @Test
    public void testWith3CharsUnequalABC() {
        assertEquals(findSubString("abc"), "bc");
    }

    @Test
    public void testWith4CharsUnequalABC() {
        assertEquals(findSubString("abbc"), "bbc");
    }

    @Test
    public void testSample01() {
        assertEquals(findSubString("abbaacab"), "abbaa");
    }

    @Test
    public void testSample02() {
        assertEquals(findSubString("abcefabbabaabefghghfa"), "abbabaab");
    }

    @Test
    public void testSample03() {
        assertEquals(findSubString("aabceddddcdccecabceftg"), "ddddcdcc");
    }

    @Test
    public void testSample04() {
        assertEquals(findSubString("acbabbcbca"), "bbcbc");
    }

}
