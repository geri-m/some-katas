package at.madlmayr.kata09;

public class MaxSubArrayDiff {

    public static void main(String[] arg) {

        int r1 = maxDiff(new int[]{2, -1, -2, 1, -4, 2, 8, -1});
        assert r1 == 1 : "Test 1";

        int r2 = maxDiff(new int[]{4, -1, 7});
        assert r2 == 16 : "Test 2";

        int r3 = maxDiff(new int[]{2, -1, -2, 12, 453, -9, 2, 8});
        assert r3 == 455 : "Test 3";

        int r4 = maxDiff(new int[]{1, -1});

        int r5 = maxDiff(new int[]{-1, 1});
    }

    static int maxDiff(int[] arr) {
        // Step 1 get left min array

        // we can do '-1', as we are not going to go to the last element in the array.
        int currentSum = 0;
        int minPointerLeft = 0;
        int minSumAtPointerRightFromLeft = Integer.MIN_VALUE;
        int maxPointerLeft = 0;
        int maxSumAtPointerRightFromLeft = Integer.MIN_VALUE;

        // finding right pointer for min & max form left side.
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (minSumAtPointerRightFromLeft == Integer.MIN_VALUE || currentSum < minSumAtPointerRightFromLeft) {
                minSumAtPointerRightFromLeft = currentSum;
                minPointerLeft = i;
            }

            if (maxSumAtPointerRightFromLeft == Integer.MIN_VALUE || currentSum > maxSumAtPointerRightFromLeft) {
                maxSumAtPointerRightFromLeft = currentSum;
                maxPointerLeft = i;
            }
        }


        int tempMinSumLeft = 0;
        int minPointerLeftFromRight = Integer.MIN_VALUE;
        int tempBestMinResult = minSumAtPointerRightFromLeft;
        int tempMaxSumLeft = 0;
        int maxPointerLeftFromRight = Integer.MIN_VALUE;
        int tempBestMaxResult = maxSumAtPointerRightFromLeft;

        for (int i = 0; i < arr.length; i++) {

            if (i <= minPointerLeft) {
                tempMinSumLeft += arr[i];
                if (minSumAtPointerRightFromLeft - tempMinSumLeft <= tempBestMinResult || minPointerLeftFromRight == Integer.MIN_VALUE) {
                    minPointerLeftFromRight = i;
                    tempBestMinResult = minSumAtPointerRightFromLeft - tempMinSumLeft;
                }
            }

            if (i <= maxPointerLeft) {
                tempMaxSumLeft += arr[i];
                if (maxSumAtPointerRightFromLeft - tempMaxSumLeft >= tempBestMaxResult || maxPointerLeftFromRight == Integer.MIN_VALUE) {
                    maxPointerLeftFromRight = i;
                    tempBestMaxResult = maxSumAtPointerRightFromLeft - tempMaxSumLeft;
                }
            }

        }

        if (minPointerLeftFromRight != Integer.MIN_VALUE && minPointerLeft != 0)
            minPointerLeftFromRight++;

        if (maxPointerLeftFromRight != Integer.MIN_VALUE && maxPointerLeft != 0)
            maxPointerLeftFromRight++;

        System.out.println("MIN from " + minPointerLeftFromRight + " to: " + minPointerLeft);
        System.out.println("MAX from " + maxPointerLeftFromRight + " to: " + maxPointerLeft);


        // Step 2 get left max array

        // diff-1


        // Step 3 get left max array


        // step 3 get right min array

        // diff-2

        // return larger diff

        return 0;

    }


}
