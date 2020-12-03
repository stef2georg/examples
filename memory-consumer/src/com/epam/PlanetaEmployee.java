package com.epam;

public class PlanetaEmployee {
    private final String name;
    private final PlanetaEmployee nextEmployee;

    public PlanetaEmployee(String name, PlanetaEmployee nextEmployee) {
        this.name = name;
        this.nextEmployee = nextEmployee;
    }
}
