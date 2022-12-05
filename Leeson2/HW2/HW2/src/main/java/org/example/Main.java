package org.example;

        import java.util.Random;

public class Homework {

    static <Employee> Employee generateEmployee (){

        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
        Random rand = new Random();
        double salary;
        switch (rand.nextInt(2)){
            case 0:
                salary = (rand.nextInt(61) + 40)*1000;
                return (Employee) new Worker(surnames[rand.nextInt(surnames.length)],names[rand.nextInt(names.length)], salary);
            case 1:
                salary = (rand.nextInt(16) + 5)*100;
                return (Employee) new freelancer(surnames[rand.nextInt(surnames.length)],names[rand.nextInt(names.length)], salary);
            default:
                return  null;
        }
    }

    public static <Employee> void main(String[] args) {

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
 * Рабочий (фулл-тайм)
 */
class Worker extends Employee{


    public Worker(String surname, String name, double salary) {
        super();
    }

    @Override
    public double calculateSalary() {
        double salary = 0;
        return salary;
    }

    @Override
    public String toString() {
        Object salary = null;
        Object name = null;
        Object surname = null;
        return String.format("%s %s; Рабочий; Заработная плата (фикс.): %.2f (руб.)",
                surname, name, salary);
    }
}

class Freelancer extends Employee{

    public Freelancer(String surname, String name, double salary) {
        super();
    }

    @Override
    public double calculateSalary() {
        int salary;
        return 20 * 8 * salary;
    }

    @Override
    public String toString() {
        Object surname = null;
        Object name = null;
        Object salary = null;
        return String.format("%s %s; Фрилансер; Ср/мес заработная плата: %.2f (руб.); Почасовая ставка: %.2f (руб.)",
                surname, name, calculateSalary(), salary);
    }
}

class freelancer extends Employee{

    public freelancer(String surname, String name, double salary) {
        super();
    }

    @Override
    public double calculateSalary() {
        int salary = 0;
        return 20 * 8 * salary;
    }

    @Override
    public String toString() {
        Object surname;
        Object name;
        Object salary;
        return String.format("%s %s; Фрилансер; Ср/мес заработная плата: %.2f (руб.); Почасовая ставка: %.2f (руб.)",
                surname, name, calculateSalary(), salary);
    }
}