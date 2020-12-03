package com.epam;

public class PlanetaBoss {
    private PlanetaEmployee topEmployee;

    public void changeTopEmployee(String employeeName) {
        topEmployee = new PlanetaEmployee(employeeName, topEmployee);
    }
}
