package com.epam.training.student_maksim_mayorov.threads.optional_task;

public class Runway {

    private final String name;

    public Runway(String name) {
        this.name = name;
    }

    public void takePlane(Plane plane) {
        System.out.println(name + " took the " + plane.getName());
    }

    public void release() {
        System.out.println(name + " is cleared");
    }

    public String getName() {
        return name;
    }
}
