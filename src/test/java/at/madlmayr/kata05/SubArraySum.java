package at.madlmayr.kata05;

public class SubArraySum {

    public static void main(String[] args) {
        int[] i1 = {};
        int o1 = 0;
        assert sumArray(i1) == o1 : "Test 1 failed";

        int[] i2 = {1};
        int o2 = 1;
        assert sumArray(i2) == o2 : "Test 2 failed";

        int[] i3 = {1, 2};
        int o3 = 6; // 1 + 2 + (1 + 2) = 6
        assert sumArray(i3) == o3 : "Test 3 failed";

        int[] i4 = {1, 3, 7};
        int o4 = 36;
        assert sumArray(i4) == o4 : "Test 4 failed";

        int[] i5 = {1, 3, 7, 4};
        int o5 = 80;
        assert sumArray(i5) == o5 : "Test 5 failed";
    }


    private static int sumArray(int[] input) {
        int result = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                for (int k = i; k <= j; k++) {
                    result += input[k];
                }
            }
        }

        return result;
    }

}
