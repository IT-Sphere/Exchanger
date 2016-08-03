package ru.itsphere.multithreadedexchanger;


public class Notifier {
    private MyExchanger a;
    public Notifier (MyExchanger a) {
        this.a = a;
    }

    public Notifier() {
        synchronized (a){
            a.setEntryThread();
            a.notifyAll();
        }
    }

}
