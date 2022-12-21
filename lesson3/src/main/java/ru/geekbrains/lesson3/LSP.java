package ru.geekbrains.lesson3;

public class LSP {

    public static void main(String[] args) {

        // Тип S будет подтипом Т тогда и только тогда,
        // когда каждому объекту oS типа S соответствует некий объект oT типа T таким образом,
        // что для всех программ P,
        // реализованных в терминах T, поведение P не будет меняться, если oT заменить на oS.


        Duck duck01 = new Duck(); // oS
        Duck duck02 = new Duck(); // oS
        Duck duck03 = new Duck(); // oS

        Bird bird01 = new Bird(); // oT
        Bird bird02 = new Bird(); // oT
        Bird bird03 = new Bird(); // oT

        Penguin penguin01 = new Penguin();

        fly(bird01);
        fly(bird02);
        fly(bird03);

        fly(duck01);
        fly(duck02);
        fly(duck03);

        fly(penguin01);
    }

    public static void fly(Bird bird){  // МЕТОД P

        if (!(bird instanceof Penguin))
            bird.fly();
    }

}

/**
 * T
 */
class Bird {
    private int flySpeed = 10;

    public int getFlySpeed() {
        return flySpeed;
    }

    public void fly(){
        System.out.printf("Птица летит со скоростью %d км/ч\n", flySpeed);
    }

}

/**
 * S
 */
class Duck extends Bird{
    @Override
    public void fly() {
        System.out.printf("Утка летит со скоростью %d км/ч\n", 8);
    }
}

class Penguin extends Bird{

    @Override
    public void fly() {
        throw new RuntimeException("Пингвин не умеет летать!");
    }
}


