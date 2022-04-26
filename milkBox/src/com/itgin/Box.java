package com.itgin;

public class Box {
    private int milk;
    private boolean state = false;

    public synchronized void put(int milk) {
        if (state) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.milk = milk;
        System.out.println("送奶工将第" + this.milk + "瓶牛奶送至奶箱");

        state = true;

        notifyAll();
    }

    public synchronized void get() {
        if(!state) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("用户拿到第" + this.milk + "瓶牛奶");

        state = false;

        notifyAll();
    }
}
