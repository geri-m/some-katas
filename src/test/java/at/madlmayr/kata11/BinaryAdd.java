package at.madlmayr.kata11;

public class BinaryAdd {

    public static void main(String[] args) {
        System.out.println(add(21, 13));
    }

    static int add(int a, int b) {
        while (b != 0) {
            int sum = a ^ b; // add without carrying
            int carry = (a & b) << 1; // carry, but don't add S
            a = sum;
            b = carry;
            System.out.println("Sum: " + sum + ", Carry: " + carry);
        }
        return a;
    }
}
