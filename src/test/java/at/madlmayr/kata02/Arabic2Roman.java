package at.madlmayr.kata02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Arabic2Roman {

    public String convert(int arabic) {

        if (arabic <= 0 && arabic > 3999) {
            return "";
        }

        if (arabic >= 1 && arabic <= 3) {
            return "I" + convert(arabic - 1);
        } else if (arabic == 4) {
            return "IV";
        } else if (arabic >= 5 && arabic <= 8) {
            return "V" + convert(arabic - 5);
        } else if (arabic == 9) {
            return "IX";
        } else if (arabic >= 10 && arabic <= 39) {
            return "X" + convert(arabic - 10);
        } else if (arabic >= 40 && arabic <= 49) {
            return "XL" + convert(arabic - 40);
        } else if (arabic >= 50 && arabic <= 89) {
            return "L" + convert(arabic - 50);
        } else if (arabic >= 90 && arabic <= 99) {
            return "XC" + convert(arabic - 90);
        } else if (arabic >= 100 && arabic <= 399) {
            return "C" + convert(arabic - 100);
        } else if (arabic >= 400 && arabic <= 499) {
            return "CD" + convert(arabic - 400);
        } else if (arabic >= 500 && arabic <= 899) {
            return "D" + convert(arabic - 500);
        } else if (arabic >= 900 && arabic <= 999) {
            return "CM" + convert(arabic - 900);
        } else if (arabic >= 1000 && arabic <= 4999) {
            return "M" + convert(arabic - 1000);
        } else {
            return "";
        }
    }


    @Test
    public void testWithNa() {
        assertEquals(convert(-10), "");
    }

    @Test
    public void testWith1() {
        assertEquals(convert(1), "I");
    }

    @Test
    public void testWith2() {
        assertEquals(convert(2), "II");
    }

    @Test
    public void testWith3() {
        assertEquals(convert(3), "III");
    }

    @Test
    public void testWith4() {
        assertEquals(convert(4), "IV");
    }

    @Test
    public void testWith5() {
        assertEquals(convert(5), "V");
    }

    @Test
    public void testWith6() {
        assertEquals(convert(6), "VI");
    }

    @Test
    public void testWith7() {
        assertEquals(convert(7), "VII");
    }

    @Test
    public void testWith8() {
        assertEquals(convert(8), "VIII");
    }

    @Test
    public void testWith9() {
        assertEquals(convert(9), "IX");
    }

    @Test
    public void testWith10() {
        assertEquals(convert(10), "X");
    }

    @Test
    public void testWith20() {
        assertEquals(convert(20), "XX");
    }

    @Test
    public void testWith39() {
        assertEquals(convert(39), "XXXIX");
    }

    @Test
    public void testWith40() {
        assertEquals(convert(40), "XL");
    }

    @Test
    public void testWith42() {
        assertEquals(convert(42), "XLII");
    }

    @Test
    public void testWith78() {
        assertEquals(convert(78), "LXXVIII");
    }

    @Test
    public void testWith89() {
        assertEquals(convert(89), "LXXXIX");
    }

    @Test
    public void testWith99() {
        assertEquals(convert(99), "XCIX");
    }

    @Test
    public void testWith100() {
        assertEquals(convert(100), "C");
    }


    @Test
    public void testWith399() {
        assertEquals(convert(399), "CCCXCIX");
    }

    @Test
    public void testWith499() {
        assertEquals(convert(499), "CDXCIX");
    }

    @Test
    public void testWith500() {
        assertEquals(convert(500), "D");
    }

    @Test
    public void testWith899() {
        assertEquals(convert(899), "DCCCXCIX");
    }

    @Test
    public void testWith999() {
        assertEquals(convert(999), "CMXCIX");
    }

    @Test
    public void testWith1000() {
        assertEquals(convert(1000), "M");
    }

    @Test
    public void testWith3999() {
        assertEquals(convert(3999), "MMMCMXCIX");
    }

}
