package com.epam;

public class PlanetaTiket {
    private final String id;

    public PlanetaTiket(String id) {
        this.id = id;
    }

    @Override
    protected void finalize() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Override
    public String toString() {
        return id;
    }
}
