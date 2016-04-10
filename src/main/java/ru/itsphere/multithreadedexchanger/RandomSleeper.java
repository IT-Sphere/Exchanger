package ru.itsphere.multithreadedexchanger;

/**
 * Ётот класс нужен дл€ остановки потоков на случайный период времени.
 * «адержка может быть от 0 с. до 10 с.
 * <p>
 * http://it-channel.ru/
 *
 * @author Budnikov Aleksandr
 */
public class RandomSleeper {

    public void sleep() throws InterruptedException {
        Integer millis = (int) (Math.random() * 10000);
        System.out.println(millis);
        Thread.sleep(millis);
    }
}
