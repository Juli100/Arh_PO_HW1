package ru.geekbrains.lesson3;

public class OCP {


    public static void main(String[] args) {

    }

}

enum ShapeType{
    Circle,
    Square
}

class SimpleDrawer{

    public void draw(Shape shape){

        switch (shape.getType()){
            case Circle:
                drawCircle();
                break;
            case Square:
                drawSquare();
                break;
        }

    }

    private void drawCircle() {

    }

    private void drawSquare() {

    }

}

class Shape{

    private ShapeType type;

    public ShapeType getType() {
        return type;
    }
}

class SimpleDrawerV2{

    public void draw(ShapeV2 shape){
        shape.draw();
    }

    public void clear(int a, int b){
        //....
    }

    public void add(int a, int b, int c){

    }

    public void add(int a, int b, int c, int d){

    }

}

abstract class ShapeV2{

    public abstract void draw();

}

class CircleV2 extends ShapeV2{


    @Override
    public void draw() {
        //....
    }
}

class Square extends ShapeV2{


    @Override
    public void draw() {
        //....
    }
}




