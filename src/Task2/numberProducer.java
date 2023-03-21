package Task2;

import java.util.concurrent.BlockingDeque;

public class numberProducer implements MyProducer{
    private int n;
    private boolean update = false;
    BlockingDeque blockingDeque;
    public numberProducer(BlockingDeque blockingDeque) {
        this.blockingDeque = blockingDeque;
    }
    @Override
    public void setN(int n) {
        this.n = n;
        update = true;
    }

    @Override
    public boolean checkUpd() {
        return update;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (checkUpd()) {
                    update = false;
                    if (n % 3 != 0 && n % 5 != 0) {
                       blockingDeque.put(String.valueOf(n));
                    }
                }
                Thread.sleep(100);
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
