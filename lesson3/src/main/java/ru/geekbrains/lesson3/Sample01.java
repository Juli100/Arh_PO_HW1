package ru.geekbrains.lesson3;

import java.awt.*;

public class Sample01 {

    /**
     * 1. Спроектировать абстрактный класс «Car» у которого должны
     * быть свойства: марка, модель, цвет, тип кузова, число колёс, тип
     * топлива, тип коробки передач, объём двигателя; методы:
     * движение, обслуживание, переключение передач, включение
     * фар, включение дворников.
     *
     * 2. Создать конкретный автомобиль путём наследования класса
     * «Car».
     *
     * 3. Расширить абстрактный класс «Car», добавить метод: подметать
     * улицу. Создать конкретный автомобиль путём наследования
     * класса «Car». Провести проверку принципа SRP.
     *
     * 4. Расширить абстрактный класс «Car», добавить метод:
     * включение противотуманных фар, перевозка груза. Провести
     * проверку принципа OCP.
     *
     * 5. Создать конкретный автомобиль путём наследования класса
     * «Car», определить число колёс = 3. Провести проверку принципа LSP.
     *
     * 6. Создать конкретный автомобиль путём наследования класса
     * «Car», определить метод «движение» - «полёт». Провести
     * проверку принципа LSP.
     *
     * 7. Создать интерфейс «Заправочная станция», создать метод:
     * заправка топливом.
     *
     * 8. Имплементировать метод интерфейса «Заправочная станция» в
     * конкретный класс «Car».
     *
     * 9. Добавить в интерфейс «Заправочная станция» методы: протирка
     * лобового стекла, протирка фар, протирка зеркал.
     *
     * 10. Имплементировать все методы интерфейса «Заправочная
     * станция» в конкретный класс «Car». Провести проверку
     * принципа ISP. Создать дополнительный/е интерфейсы и
     * имплементировать их в конкретный класс «Car». Провести
     * проверку принципа ISP.
     *
     *
     * 11. Создать путём наследования класса «Car» два
     * автомобиля: с бензиновым и дизельным двигателями,
     * имплементировать метод «Заправка топливом» интерфейса
     * «Заправочная станция». Реализовать заправку каждого
     * автомобиля подходящим топливом. Провести проверку принципа DIP.
     */

    //TODO: ДОМАШНЯЯ РАБОТА
    // Разработать UML-диаграмму классов для нашего модуля Sample01




    public static void main(String[] args) {

    }

    public static double calculateMaintenance(Car car){
        if (car.getWheelsCount() == 6){
            return 900*6;
        }
        else {
            return 1000*4;
        }
    }

}

/**
 * Заправочная станция
 */
interface Refueling{

    /**
     * Заправка
     */
    void fuel(FuelType fuelType);


}

class RefuelingStation implements Refueling{


    @Override
    public void fuel(FuelType fuelType) {
        switch (fuelType){
            case Gasoline -> System.out.println("Заправили бензином.");
            case Diesel -> System.out.println("Заправили дизельным топливом.");
        }
    }
}

class RefuelingStation2 implements Refueling{


    @Override
    public void fuel(FuelType fuelType) {
        switch (fuelType){
            case Gasoline -> System.out.println("Заправили бензином.");
            case Diesel -> throw new RuntimeException("Не обслуживается.");
        }
    }
}

class RefuelingStation3 implements Refueling{


    @Override
    public void fuel(FuelType fuelType) {
        switch (fuelType){
            case Gasoline -> System.out.println("Заправили бензином.");
            case Diesel -> System.out.println("Заправили дизельным топливом.");
        }
    }
}

interface Wiping{
    void wipMirrors();
    void wipWindshield();
    void wipHeadlights();
}

/**
 * Тип кузова
 */
enum CarType{
    Sedan,
    Hatchback,
    Pickup,
    Sport
}

/**
 * Тип топлива
 */
enum FuelType{
    Diesel,
    Gasoline
}

/**
 * Тип коробки передач
 */
enum GearboxType{
    AT, // Automatic transmission
    MT  // Manual transmission
}

class SuperCar extends Car implements Wiping{

    public SuperCar(){
        type = CarType.Sport;
        wheelsCount = 3;
        fuelType = FuelType.Gasoline;
    }

    @Override
    public void movement() {
        fly();
    }

    public void fly(){
        System.out.println("Машина летит.");
    }

    @Override
    public void maintenance() {

    }

    @Override
    public void gearShifting() {

    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }



    @Override
    public void wipMirrors() {

    }

    @Override
    public void wipWindshield() {

    }

    @Override
    public void wipHeadlights() {

    }
}

class Harvester extends Car{


    public Harvester(){
        wheelsCount = 6;
        fuelType = FuelType.Diesel;
    }


    public void sweeping(){
        System.out.println("Автомобиль подметает улицу");
    }

    @Override
    public void movement() {
        System.out.println("Автомобиль находится в движении.");
    }

    @Override
    public void maintenance() {

    }

    @Override
    public void gearShifting() {

    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }

    @Override
    public void shipping() {
        //...
    }
}

abstract class Car{

    //region


    public int getWheelsCount() {
        return wheelsCount;
    }



    Refueling station;

    public void setRefuelingStation(Refueling station){
        this.station = station;
        fuel();
    }

    // Заправка
    public void fuel(){
        station.fuel(fuelType);
    }

    // Движение
    public abstract void movement();
    // Обслуживание
    public abstract void maintenance();
    // Переключение передач
    public abstract void gearShifting();
    // Включение фар
    public abstract boolean switchHeadlights();
    // Включение дворников
    public abstract boolean switchWipers();



    // Перевозка груза
    public void shipping(){
        System.out.printf("Автомобиль перевозит груз весом %d кг.\n", loadCapacity);
    }

    //endregion

    //region Private Fields


    // Грузоподъемность
    private int loadCapacity;


    // Марка автомобиля
    private String make;
    // Модель
    private String model;
    // Цвет
    private Color color;
    // Тип
    protected CarType type;
    // Число колес
    protected int wheelsCount;
    // Тип топлива
    protected FuelType fuelType;
    // Тип коробки передач
    private GearboxType gearboxType;
    // Объем двигателя
    private double engineCapacity;

    //endregion




}














