package ru.denzol.springcourse;

public class RockMusic implements Music{
    public void doMyInit() {
        System.out.println("Init: " + this.getClass().getSimpleName());
    }
    @Override
    public String getSong() {
        return "I am rock";
    }

    public void doMyDestroy() {
        System.out.println("Destroy: " + this.getClass().getSimpleName());
    }
}
