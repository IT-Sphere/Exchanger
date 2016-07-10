package ru.itsphere.multithreadedexchanger;

/**
 * Этот класс нужен для остановки потоков на случайный период времени.
 * Задержка может быть от 0 с. до 2 с.
 * <p>
 * http://it-channel.ru/
 *
 * @author Budnikov Aleksandr
 */
public class RandomSleeper {

    public void sleep() throws InterruptedException {
        Integer millis = (int) (Math.random() * 2000);
        System.out.println(millis);
        Thread.sleep(millis);
    }
}
