package ru.itsphere.multithreadedexchanger;

public class MyExchanger<T> {

    private boolean entryThread = false;

    private T firstObject;
    private T secondObject;

    public T exchange(T object) {
        synchronized (object) {

            while (!entryThread)
                try {
                    if (firstObject != null) {
                        System.out.println("Come in 'firstObject'");
                        this.secondObject = object;
                        entryThread = true;
                        firstObject.wait();
                        return secondObject;

                    } else {
                        System.out.println("Come in 'secondObject'");
                        this.firstObject = object;
                        entryThread = true;
                        secondObject.wait();
                        return firstObject;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }

        return null;
    }

    public void setEntryThread() {
        entryThread = true;
    }


}
