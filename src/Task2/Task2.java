package Task2;


import java.util.concurrent.*;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> deque = new LinkedBlockingDeque<>();

        MyProducer fizzProd = new fizzProducer(deque);
        MyProducer buzzProd = new buzzProducer(deque);
        MyProducer fizzBuzzProd = new fizzBuzzProducer(deque);
        MyProducer numberProd = new numberProducer(deque);
        printConsumer printConsumer = new printConsumer(deque);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.execute(fizzProd);
        executor.execute(buzzProd);
        executor.execute(fizzBuzzProd);
        executor.execute(numberProd);
        executor.execute(printConsumer);


        for (int i = 1; i <= 100; i++) {
            fizzProd.setN(i);
            buzzProd.setN(i);
            fizzBuzzProd.setN(i);
            numberProd.setN(i);
            while (fizzProd.checkUpd() || buzzProd.checkUpd()
                    || fizzBuzzProd.checkUpd() || numberProd.checkUpd()){
                Thread.sleep(100);
            }
        }
    }
}
