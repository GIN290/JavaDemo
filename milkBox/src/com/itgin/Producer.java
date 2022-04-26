package com.itgin;

public class Producer implements Runnable {
    private Box b;
    public Producer(Box b) {
        this.b = b;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 1; i <= 30; i++) {
                b.put(i);
            }
        }
    }
}
