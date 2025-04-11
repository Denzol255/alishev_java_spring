package ru.denzol.springcourse;

public class RapMusic implements Music{
    public void doMyInit() {
        System.out.println("Init: " + this.getClass().getSimpleName());
    }

    public void doMyDestroy() {
        System.out.println("Destroy: " + this.getClass().getSimpleName());
    }
    @Override
    public String getSong() {
        return "Lost yourself";
    }
}
