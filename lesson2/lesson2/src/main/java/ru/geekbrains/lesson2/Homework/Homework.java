  package ru.geekbrains.lesson2.Homework;
  import java.util.Random;

public class Homework {

    public class Genrate {

        public Employee generateEmployee() {
            String[] names = new String[]{ "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
            String[] surnames = new String[]{ "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
            Random random = new Random();
            boolean number = random.nextBoolean();
            if(number){
                return new Worker(names[random.nextInt(names.length)],
                            surnames[random.nextInt(surnames.length)],
                            random.nextInt((50000 - 40000) + 1) + 40000);
            }
            else {
                return new Freelancer(names[random.nextInt(names.length)],
                            surnames[random.nextInt(surnames.length)],
                            random.nextInt((1000 - 500) + 1) + 500);
            }
        }
    }
        /*
         String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

         */
    }

  public class Main {

      public static void main(String[] args) {
          Employee [] employees = new Employee[10];

          for (int i = 0; i < employees.length; i++) {
              Genrate genrate = new Genrate();
              employees[i] = genrate.generateEmployee();
          }

          for (Employee e: employees) {
              System.out.println(e);
          }

      }
  }

    public static void main(String[] args) {
        Employee worker1 = new Worker("Анатолий", "Шестаков", 40000);
       System.out.println(worker1);
        


        //TODO: 1. Доработать метод generateEmployee, вы должны уметь возвращать все типы
        // сотрудников.
        //TODO: 2***. Сотрудник формируется автоматически, метод generateEmployee не имеет параметров.


        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++){
            employees[i] = generateEmployee();
        }

        for (Employee e: employees) {
            System.out.println(e);
        }

    }

}

/**
 * Работник (базовый класс)
 */
abstract class Employee{
    protected String name;
    protected String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Ставка
     */
    protected double salary;

    public Employee(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    /**
     * Расчет среднемесячной заработной платы
     * @return
     */
    public abstract double calculateSalary();

}

class Freelancer extends Employee{

    public Freelancer(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    public double calculateSalary() {
        return 20 * 8 * salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Фрилансер; Среднемесячная заработная плата: %.2f (руб.); Почасовая ставка: %.2f (руб.)",
                surname, name, calculateSalary(), salary);
    }
}

/**
 * Рабочий (фулл-тайм)
 */
class Worker extends Employee{


    public Worker(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f (руб.)",
                surname, name, salary);
    }
}