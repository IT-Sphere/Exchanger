package ru.itsphere.multithreadedexchanger;

import java.util.concurrent.Exchanger;

/**
 * Класс покупатель
 * <p>
 * http://it-channel.ru/
 *
 * @author Budnikov Aleksandr
 */
public class Buyer extends Thread {

    private final RandomSleeper sleepTimeInterval;
    private final MyExchanger<String> exchanger;
    private String money;
    private String product;

    public Buyer(MyExchanger<String> exchanger, String money, RandomSleeper sleepTimeInterval) {
        this.exchanger = exchanger;
        this.money = money;
        this.sleepTimeInterval = sleepTimeInterval;
    }

    @Override
    public void run() {
        try {
            sleepTimeInterval.sleep();

            synchronized (exchanger) {
                exchanger.setEntryThread();
                exchanger.notify();
            }

            product = exchanger.exchange(money);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        money = "0$";
        System.out.println("Buyer has " + product + " but has " + money + ".");


    }
}
