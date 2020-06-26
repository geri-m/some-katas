package at.madlmayr.kata10;

public class MinHeap {

    public static void main(String[] args) {
        int[] h1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        h1 = pop(h1);
        System.out.println(toString(h1));
        assert checkArrayEqual(h1, new int[]{1, 3, 2, 7, 4, 5, 6, 14, 8, 9, 10, 11, 12, 13});
        h1 = pop(h1);
        System.out.println(toString(h1));
        assert checkArrayEqual(h1, new int[]{2, 3, 5, 7, 4, 11, 6, 14, 8, 9, 10, 13, 12});
        h1 = pop(h1);
        System.out.println(toString(h1));
        assert checkArrayEqual(h1, new int[]{3, 4, 5, 7, 9, 11, 6, 14, 8, 12, 10, 13});


        int[] h2 = new int[]{};
        h2 = push(h2, 0);
        System.out.println(toString(h2));
        assert checkArrayEqual(h2, new int[]{0});
        h2 = push(h2, 1);
        System.out.println(toString(h2));
        assert checkArrayEqual(h2, new int[]{0, 1});
        h2 = push(h2, 2);
        System.out.println(toString(h2));
        assert checkArrayEqual(h2, new int[]{0, 1, 2});

        h2 = push(h2, 4);
        System.out.println(toString(h2));
        assert checkArrayEqual(h2, new int[]{0, 1, 2, 4});
        h2 = push(h2, 5);
        System.out.println(toString(h2));
        assert checkArrayEqual(h2, new int[]{0, 1, 2, 4, 5});
        h2 = push(h2, 6);
        System.out.println(toString(h2));
        assert checkArrayEqual(h2, new int[]{0, 1, 2, 4, 5, 6});

        h2 = push(h2, 3);
        System.out.println(toString(h2));
        assert checkArrayEqual(h2, new int[]{0, 1, 2, 4, 5, 6, 3});

        h2 = push(h2, 1);
        System.out.println(toString(h2));
        assert checkArrayEqual(h2, new int[]{0, 1, 2, 1, 5, 6, 3, 4});
    }

    public static String toString(int[] arr) {

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]).append(", ");
        }

        sb.append(arr[arr.length - 1]).append("}");
        return sb.toString();
    }

    public static boolean checkArrayEqual(int[] a, int[] b) {
        if (a.length != b.length)
            return false;


        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }

        return true;
    }

    public static int[] pop(int[] arr) {

        if (arr.length == 0) {
            return new int[]{};
        }

        arr[0] = arr[arr.length - 1];
        int[] arrNew = new int[arr.length - 1];
        System.arraycopy(arr, 0, arrNew, 0, arrNew.length);
        arr = arrNew;
        reArrangeAfterPop(arr, 0);
        return arr;
    }

    public static void reArrangeAfterPop(int[] arr, int pos) {
        int left = pos * 2 + 1;
        int right = pos * 2 + 2;

        int newPos = pos;

        if (right < arr.length && arr[pos] > arr[right] && arr[left] > arr[right]) {
            newPos = right;
        }

        if (left < arr.length && arr[pos] > arr[left] && arr[right] > arr[left]) {
            newPos = left;
        }

        if (newPos != pos) {
            int temp = arr[newPos];
            arr[newPos] = arr[pos];
            arr[pos] = temp;
            reArrangeAfterPop(arr, newPos);
        }
    }


    public static int[] push(int[] arr, int append) {
        int[] arrNew = new int[arr.length + 1];
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        arrNew[arr.length] = append;
        reArrangeAfterPush(arrNew, arr.length);
        return arrNew;
    }

    public static void reArrangeAfterPush(int[] arr, int pos) {

        int parent;
        // 1. figure out if we are left or right.
        if (pos % 2 == 0) {
            // right
            parent = (pos - 2) / 2;
        } else {
            // left
            parent = (pos - 1) / 2;
        }
        if (parent < 0) {
            return;
        }

        if (arr[parent] > arr[pos]) {
            int min = arr[pos];
            arr[pos] = arr[parent];
            arr[parent] = min;
            reArrangeAfterPush(arr, parent);
        }
    }

}
