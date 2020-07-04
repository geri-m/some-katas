package at.madlmayr.kata14;

public class GenSum {

    public static void generatedResults(int base, int input, String preFix) {

        int lookupCounter;

        if (base > input) {
            lookupCounter = input;
        } else {
            lookupCounter = base;
        }

        for (int i = lookupCounter; i > 0; i--) {
            int diff = input - i;

            if (diff > 0) {
                generatedResults(i, diff, preFix + " " + i + "+");
            } else {
                System.out.println(preFix + input + ",");
            }
        } // for
    }

    public static void main(String[] args) {
        generatedResults(6, 6, "");

    }


}
