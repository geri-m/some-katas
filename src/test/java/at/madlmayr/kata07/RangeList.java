package at.madlmayr.kata07;

public class RangeList {

    public static void main(String[] arg) {

        int r1 = range(new int[]{0, 1, 2});
        assert r1 == 2;

        int r2 = range(new int[]{10, 20, 30});
        assert r2 == 20;

        // Sample 01
        // Duplicated: yes.
        // Negative Numbers: no.
        // Only Ints.
        // no limits (in array size, nor in amount of arrays)
        // Starting from 0.
        // no empty array
        // at least one array
        String s1 = toString(posToRangeInput(new int[]{3, 3, 2}, new int[][]{{4, 10, 15, 24, 26}, {0, 9, 12, 20}, {5, 18, 22, 30}}));
        assert s1.equals("24 20 22 ");

        int r4 = range(rangeFinder(new int[][]{{0}}));
        assert r4 == 0;

        int r5 = range(rangeFinder(new int[][]{{1}}));
        assert r5 == 0;

        int r6 = range(rangeFinder(new int[][]{{0}, {1}}));
        assert r6 == 1;

        int r7 = range(rangeFinder(new int[][]{{4, 10, 15, 24, 26}, {0, 9, 12, 20}, {5, 18, 22, 30}}));
        assert r7 == 4;
    }

    public static int[] rangeFinder(int[][] input) {
        // this contains the values
        int[] posResult = new int[input.length];

        // this contains the points
        // this is zero by design.
        int[] posWorking = new int[input.length];

        // stores the value, where the pointers are pointing to.
        int[] valuesWorking = new int[input.length];


        int rangeResult = -1;
        boolean searching = true;

        while (searching) {
            for (int i = 0; i < input.length; i++) {
                valuesWorking[i] = input[i][posWorking[i]];
            }
            int rangeWorking = range(valuesWorking);

            System.out.println("Input: " + toString(valuesWorking));
            System.out.println("Range: " + rangeWorking);

            if (rangeWorking < rangeResult || rangeResult == -1) {
                rangeResult = rangeWorking;
                System.arraycopy(posWorking, 0, posResult, 0, input.length);
            }

            // now we look of the min in the next "colum"

            // 1. check, if all array have an additional element
            int listId = -1;
            int value = -1;
            for (int j = 0; j < input.length; j++) {

                // Not really. Abbruch is only, if the lowest number is in the last element of the Array. 
                if (input[j].length <= posWorking[j] + 1) {
                    System.out.println("We have one array, where we don't have any more elements");
                }
                // there is an additional element, check this one for a next step
                else {
                    if (listId == -1 || input[j][posWorking[j] + 1] < value) {
                        value = input[j][posWorking[j] + 1];
                        listId = j;
                    }
                }
            }

            // now if listId is -1 and therefore not modified, all ists have the pointers on the last element. we break
            if (listId == -1) {
                System.out.println("All List are at last Element");
                searching = false;
            } else {
                System.out.println("List ID to increment: " + listId);
                posWorking[listId]++;
            }
        }
        return posToRangeInput(posResult, input);
    }

    public static int[] posToRangeInput(int[] pos, int[][] lists) {
        int[] valueResult = new int[pos.length];
        for (int i = 0; i < pos.length; i++) {
            valueResult[i] = lists[i][pos[i]];
        }

        return valueResult;
    }

    public static int range(int[] input) {
        int low = -1;
        int high = -1;

        for (int value : input) {
            // to have the first value initailized
            if (low > value || low == -1)
                low = value;

            if (high < value)
                high = value;
        }

        return high - low;
    }

    public static String toString(int[] input) {
        StringBuilder sb = new StringBuilder();

        for (int value : input) {
            sb.append(value).append(" ");
        }

        return sb.toString();
    }
}
