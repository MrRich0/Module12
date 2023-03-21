package Task2;

import java.util.concurrent.BlockingDeque;

public class printConsumer implements Runnable {
    BlockingDeque blockingDeque;

    public printConsumer(BlockingDeque blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        while (true){
            while (!blockingDeque.isEmpty()){
                System.out.print(blockingDeque.poll() + " ");
            }
        }
    }
}
