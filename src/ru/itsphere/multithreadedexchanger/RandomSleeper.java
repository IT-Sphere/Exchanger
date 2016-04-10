package ru.itsphere.multithreadedexchanger;

/**
 * ���� ����� ����� ��� ��������� ������� �� ��������� ������ �������.
 * �������� ����� ���� �� 0 �. �� 10 �.
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
