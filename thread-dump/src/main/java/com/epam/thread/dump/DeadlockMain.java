package com.epam.thread.dump;

import java.util.concurrent.locks.ReentrantLock;

public class DeadlockMain {

    private static final ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Friend spens = new Friend("Spens");
        Friend mishoShamara = new Friend("Misho Shamara");

        new Thread(() -> spens.ask(mishoShamara)).start();
        new Thread(() -> mishoShamara.ask(spens)).start();

        new Thread(() -> {
            reentrantLock.lock();
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }).start();
    }

    private static class Friend {

        private final String name;

        Friend(String name) {
            this.name = name;
        }

        synchronized void ask(Friend friend) {
            System.out.format("%s: Kvo stava, %s!%n", this.name, friend.name);
            friend.answer(this);
        }

        synchronized void answer(Friend friend) {
            System.out.format("%s: %s, dobre sym brat!%n", this.name, friend.name);
        }

    }


}
