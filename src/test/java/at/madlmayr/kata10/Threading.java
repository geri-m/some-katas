package at.madlmayr.kata10;

public class Threading implements Runnable {

    public static void main(String[] arg) {

        for (int i = 0; i < 10; i++) {
            Threading x = new Threading();
            Thread y = new Thread(x);
            y.start();
        }


    }


    @Override
    public void run() {
        System.out.println("Start Thread");
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End Thread");
    }
}
