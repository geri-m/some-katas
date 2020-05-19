package at.madlmayr.kata03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementEliminator {

    public String[] eliminate(String[] input) {

        if (input == null || input.length == 0) {
            return null;
        } else {
            Set<String> result = new TreeSet<String>(Arrays.asList(input));
            String[] returnValue = new String[result.size()];
            result.toArray(returnValue);
            System.out.println(result);
            return returnValue;
        }
    }

    @Test
    public void testWithNa() {
        assertEquals(eliminate(null), null);
    }

    @Test
    public void testWith0() {
        assertEquals(eliminate(new String[]{}), null);
    }

    @Test
    public void testWith1() {
        assertEquals(eliminate(new String[]{"01"})[0], "01");
    }

    @Test
    public void testWith2() {
        assertEquals(eliminate(new String[]{"01", "01"})[0], "01");
    }

    @Test
    public void testWith22() {
        assertEquals(eliminate(new String[]{"01", "02"})[0], "01");
        assertEquals(eliminate(new String[]{"01", "02"})[1], "02");
    }

    @Test
    public void testWith3() {
        assertEquals(eliminate(new String[]{"foo", "bar", "baz", "foo", "bar"})[0], "bar");
        assertEquals(eliminate(new String[]{"foo", "bar", "baz", "foo", "bar"})[1], "baz");
        assertEquals(eliminate(new String[]{"foo", "bar", "baz", "foo", "bar"})[2], "foo");
    }


}
