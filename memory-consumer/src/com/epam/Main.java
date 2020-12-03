package com.epam;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Planeta application started...");
        PlanetaBoss boss = new PlanetaBoss();
        int counter = 0;
        while (true) {
            PlanetaTiket tiket = new PlanetaTiket("Planeta " + System.currentTimeMillis());
            boss.changeTopEmployee("Radka Piratka with ticket for " + tiket);
            PlanetaCache.addSinger(new PlanetaSinger("Fiki Storaro and his brother"));

            counter++;
            if (counter % 10 == 0) {
                Thread.sleep(1);
            }
        }
    }
}
