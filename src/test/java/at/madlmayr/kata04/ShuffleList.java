package at.madlmayr.kata04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShuffleList {

    /**
     * @param input First Element of a List of not-Shuffled Elements
     * @return First Element of a List of shuffled Elements
     */

    public Element shuffle(Element input) {

        // don't process, if we don't have an input
        if (input == null) {
            return null;
        }

        // don't process, if the amount of elements are odd
        int lenOfList = getSizeOfList(input);
        if (lenOfList % 2 == 1) {
            return null;
        }

        // 2nd half of list
        int lenOfHalfList = lenOfList / 2;

        // Finding start point of 2nd half
        Element startOfSecondHalf = input;
        for (int walkThurCounter = 0; walkThurCounter < lenOfHalfList; walkThurCounter++) {
            startOfSecondHalf = startOfSecondHalf.getNextElement();
        }


        Element backupNewStart = startOfSecondHalf;
        // Rewiring the list
        for (int walkThurCounter = 0; walkThurCounter < lenOfHalfList; walkThurCounter++) {
            // we store the Element where the current 2nd half is pointing to
            Element backupElement1 = input.getNextElement();
            Element backupElement2 = startOfSecondHalf.getNextElement();
            startOfSecondHalf.setNextElement(input);
            input.setNextElement(backupElement2);

            if (backupElement2 != null) {
                startOfSecondHalf = backupElement2;
                input = backupElement1;
            }
        }

        return backupNewStart;
    }

    /**
     * @param input Start Element of the Linked List
     * @return The Length of the list.
     */

    public int getSizeOfList(Element input) {
        if (input == null) {
            return 0;
        }

        Element start = input;
        int counter = 1;

        // walk thru the list, till the next Element is null and we are at the end of the list.
        while (start.getNextElement() != null) {
            counter++;
            start = start.getNextElement();
        }
        return counter;
    }

    @Test
    public void shuffle0() {
        assertEquals(shuffle(null), null);
    }

    @Test
    public void shuffle1() {
        Element value0 = new Element(0);
        assertEquals(shuffle(value0), null);
        assertEquals(value0.toString(), "0");
    }

    @Test
    public void shuffle2() {
        Element value0 = new Element(0);
        Element value1 = new Element(1);
        value0.setNextElement(value1);
        assertEquals(value0.toString(), "0 1");
        assertEquals(value1.toString(), "1");
        shuffle(value0);
        // assertEquals(shuffle(value0), null);
        assertEquals(value0.toString(), "0");
        assertEquals(value1.toString(), "1 0");
    }

    @Test
    public void shuffle10() {
        Element value1 = new Element(1);
        Element value2 = new Element(2);
        value1.setNextElement(value2);
        Element value3 = new Element(3);
        value2.setNextElement(value3);
        Element value4 = new Element(4);
        value3.setNextElement(value4);
        Element value5 = new Element(5);
        value4.setNextElement(value5);
        Element value6 = new Element(6);
        value5.setNextElement(value6);
        Element value7 = new Element(7);
        value6.setNextElement(value7);
        Element value8 = new Element(8);
        value7.setNextElement(value8);
        Element value9 = new Element(9);
        value8.setNextElement(value9);
        Element value10 = new Element(10);
        value9.setNextElement(value10);

        assertEquals(value1.toString(), "1 2 3 4 5 6 7 8 9 10");
        Element shuffled = shuffle(value1);
        assertEquals(shuffled.toString(), "6 1 7 2 8 3 9 4 10 5");
    }

    @Test
    public void testListLength1() {
        Element value0 = new Element(0);
        Element value1 = new Element(1);
        Element value2 = new Element(2);
        value0.setNextElement(value1);
        value1.setNextElement(value2);
        assertEquals(getSizeOfList(value0), 3);
        assertEquals(getSizeOfList(value1), 2);
        assertEquals(getSizeOfList(value2), 1);
        assertEquals(value0.toString(), "0 1 2");
    }

    private class Element {

        private final int value;
        private Element nextElement;

        public Element(int value) {
            this.value = value;
        }

        public Element getNextElement() {
            return nextElement;
        }

        public void setNextElement(Element nextElement) {
            this.nextElement = nextElement;
        }

        public int getValue() {
            return this.value;
        }

        public String toString() {
            StringBuilder out = new StringBuilder();
            Element start = this;
            out.append(start.getValue());

            // walk thru the list, till the next Element is null and we are at the end of the list.
            while (start.getNextElement() != null) {
                start = start.getNextElement();
                out.append(" ").append(start.getValue());
            }

            return out.toString();
        }
    }
}
