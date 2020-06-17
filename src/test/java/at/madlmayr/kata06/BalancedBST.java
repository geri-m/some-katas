package at.madlmayr.kata06;

public class BalancedBST {

    private Node root;

    public BalancedBST() {

    }

    public static void main(String[] arg) {
        BalancedBST t1 = new BalancedBST();
        t1.insertBalanced(t1.new Node(1));
        String r1 = t1.toString();
        System.out.println(r1);
        System.out.println(t1.root.balanced());
        assert r1.equals("1(0)[,]") : "Test 1 Fail";
        int b1 = t1.root.balanced();
        assert b1 == 0 : "Balanced 1 Fail";

        BalancedBST t2 = new BalancedBST();
        t2.insertBalanced(t2.new Node(1));
        t2.insertBalanced(t2.new Node(2));
        t2.insertBalanced(t2.new Node(3));
        String r2 = t2.toString();
        System.out.println(r2);
        System.out.println(t2.root.balanced());
        assert r2.equals("1(0)[,2(1)[,3(2)[,]]]") : "Test 2 Fail";
        int b2 = t2.root.balanced();
        assert b2 == 2 : "Balanced 2 Fail";

        BalancedBST t3 = new BalancedBST();
        t3.insertBalanced(t3.new Node(2));
        t3.insertBalanced(t3.new Node(1));
        t3.insertBalanced(t3.new Node(3));
        String r3 = t3.toString();
        System.out.println(r3);
        System.out.println(t3.root.balanced());
        assert r3.equals("2(0)[1(1)[,],3(1)[,]]") : "Test 3 Fail";
        int b3 = t3.root.balanced();
        assert b3 == 0 : "Balanced 3 Fail";

        BalancedBST t4 = new BalancedBST();
        t4.insertBalanced(t4.new Node(2));
        t4.insertBalanced(t4.new Node(1));
        String r4 = t4.toString();
        System.out.println(r4);
        System.out.println(t4.root.balanced());
        assert r4.equals("2(0)[1(1)[,],]") : "Test 4 Fail";
        int b4 = t4.root.balanced();
        assert b4 == -1 : "Balanced 4 Fail";
    }

    public void insertBalanced(Node n) {
        if (this.root == null) {
            this.root = n;
            n.setHeight(0);
        } else {
            this.root.append(n, 0);
        }
    }

    public String toString() {
        return this.root.toString();
    }

    public class Node {

        private final int value;
        private Node left;
        private Node right;
        // we store the height in each node for simplicity reasons.
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public int getHeight() {
            return this.height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        /**
         * appends a node; this is a recursive function and will add the node down the road
         *
         * @param n      Node to be added
         * @param height height of the current node.
         */
        public void append(Node n, int height) {
            if (n.getValue() > this.value) {
                // right
                if (right == null) {
                    right = n;
                    right.setHeight(height + 1);
                } else {
                    right.append(n, height + 1);
                }

            } else if (n.getValue() < this.value) {
                // left
                if (left == null) {
                    left = n;
                    left.setHeight(height + 1);
                } else {
                    left.append(n, height + 1);
                }
            } else {
                // do nothing. There are no duplicates in a Tree.
            }
        }

        /**
         * Gives an indication whether the subtree from this node is balanced or not.
         * If the subtree is net balanced, we need to rotated.
         *
         * @return int value: < -1 left to deep > 1 right to deep
         */

        public int balanced() {
            if (left == null && right == null) {
                return 0;
            } else if (left != null && right == null) {
                return left.getDepth();
            } else if (left == null && right != null) {
                return right.getDepth();
            } else {
                return right.getDepth() - left.getDepth();
            }
        }

        public int getDepth() {
            if (left == null && right == null) {
                return height;
            } else if (left != null && right == null) {
                return left.getDepth() * (-1);
            } else if (left == null && right != null) {
                return right.getDepth();
            } else {
                return Math.max(left.getDepth(), right.getDepth());
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(value).append("(").append(getHeight()).append(")").append("[");
            if (left != null)
                sb.append(left.toString());
            sb.append(",");
            if (right != null)
                sb.append(right.toString());
            sb.append("]");
            return sb.toString();
        }
    }
}


