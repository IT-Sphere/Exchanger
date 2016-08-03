package ru.itsphere.multithreadedexchanger;

import java.util.concurrent.Exchanger;

/**
 * Класс продавец
 * <p>
 * http://it-channel.ru/
 *
 * @author Budnikov Aleksandr
 */
public class Seller extends Thread {

    private final RandomSleeper sleepTimeInterval;
    private final MyExchanger<String> exchanger;
    private String money;
    private String product;

    public Seller(MyExchanger<String> exchanger, String product, RandomSleeper sleepTimeInterval) {
        this.exchanger = exchanger;
        this.product = product;
        this.sleepTimeInterval = sleepTimeInterval;
    }

    @Override
    public void run() {
        try {

            sleepTimeInterval.sleep();

            synchronized (exchanger){
                exchanger.setEntryThread();
                exchanger.notify();
            }

            money = exchanger.exchange(product);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        product = "no product";
        System.out.println("Seller has " + product + " but has " + money + ".");





    }
}