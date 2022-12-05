package ru.geekbrains.seminar1.modelelements;

import java.util.Collection;
public class Flash {

    private Point3D location;

    private Angle3D angle;

    private String color;

    private float power;

    public Point3D getLocation() {
        return location;
    }

    public void setLocation(Point3D location) {
        this.location = location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public void setAngle(Angle3D angle) {
        this.angle = angle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public void Rotate(Angle3D angle) {
        this.angle = angle;
    }

    public void Move(Point3D location) {

        this.location = location;

    }


    //TODO: Доработать ...
}
