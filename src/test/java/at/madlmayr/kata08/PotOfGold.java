package at.madlmayr.kata08;

public class PotOfGold {

    public static void main(String[] arg) {
        int[] p1 = playOfOfGold(new int[]{1, 3, 1});
        assert p1[0] == 2 : "Game 1 failed (A)";
        assert p1[1] == 3 : "Game 1 failed (B)";

        int[] p2 = playOfOfGold(new int[]{1, 1, 1});
        assert p2[0] == 2 : "Game 2 failed (A)";
        assert p2[1] == 1 : "Game 2 failed (B)";

        int[] p3 = playOfOfGold(new int[]{1, 3, 2, 5, 4, 1, 7});
        assert p3[0] == 16 : "Game 3 failed (A)";  // 7-3-5-1
        assert p3[1] == 7 : "Game 3 failed (B)";  // 1-2-4


    }


    /**
     * Method to play the "pots of gold" game.
     *
     * @param pots int array with the different pots of gold
     * @return boolean if "A" is winning (A is the starting party)
     */
    static int[] playOfOfGold(int[] pots) {
        int left = 0;
        int right = pots.length - 1;
        int[] value = new int[2];
        int round = 0;
        recursivePlay(pots, left, right, value, round);
        return value;
    }


    static void recursivePlay(int[] pots, int left, int right, int[] values, int round) {
        if (left > right) {
            return;
        }

        if (left == right) {
            values[round % 2] += pots[left];
            return;
        }


        int diffLeft = pots[left + 1] - pots[left];
        int diffRight = pots[right - 1] - pots[right];

        if (diffLeft < diffRight) {
            values[round % 2] += pots[left];
            left++;
        } else if (diffRight < diffLeft) {
            values[round % 2] += pots[right];
            right--;
        } else {
            if (pots[left] > pots[right]) {
                values[round % 2] += pots[left];
                left++;
            } else {
                values[round % 2] += pots[right];
                right--;
            }
        }

        round++;
        recursivePlay(pots, left, right, values, round);
    }
}

