package ru.itsphere.multithreadedexchanger;

public class
Main {

    public static void main(String[] args) {
        MyExchanger<String> exchanger = new MyExchanger();

        RandomSleeper sleeper = new RandomSleeper();
        Seller seller = new Seller(exchanger, "iPhone", sleeper);
        Buyer buyer = new Buyer(exchanger, "1000$", sleeper);

        seller.start();
        buyer.start();
    }
}
