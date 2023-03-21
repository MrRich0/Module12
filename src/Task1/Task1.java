package Task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    private static AtomicInteger timer = new AtomicInteger(0);
    public static void main(String[] args) {
            new Thread(() -> {
            while (true) {
                timer.incrementAndGet();
                System.out.println("З моменту запуску програми пройшло " + timer +"c.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Пройшло 5c.");
            }
        }).start();
    }
}