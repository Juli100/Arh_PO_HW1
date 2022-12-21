package ru.geekbrains.lesson4;

import java.util.ArrayList;
import java.util.Scanner;

public class Sample02 {

    public static void main(String[] args) {

        FactoryProviderV1 factoryProviderV1 = new FactoryProviderV1();
        DealerProviderV1 dealerProviderV1 = new DealerProviderV1(factoryProviderV1);


        //ComponentInfo component = dealerProviderV1.getComponent(900002);
        //System.out.println(component);

        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.print("Укажите номер детали: #");
                if (scanner.hasNextInt()) {
                    int no = scanner.nextInt();
                    scanner.nextLine();
                    if (no <= 0) {
                        System.out.println("Укажите корректный номер детали. Номер детали должен быть > 0.");
                        continue;
                    }
                    ComponentInfo componentInfo = dealerProviderV1.getComponent(no);
                    System.out.println(componentInfo);
                } else {
                    System.out.println("Укажите корректный номер детали.");
                    scanner.nextLine();
                }
            }
            catch (RuntimeException e){
                System.out.println(e.getMessage());

            }
        }





    }

}

/**
 * Информация о детали
 */
class ComponentInfo{

    private int id;
    private String description;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public ComponentInfo(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("#%d - %s", id, description);
    }
}

/**
 * Завод по производству деталей
 */
class FactoryProviderV1{
    private ArrayList<ComponentInfo> components = new ArrayList<>();

    {
        for (int i = 0; i < 10; i++){
            components.add(new ComponentInfo(900000 + i, String.format("component description %d", 900000 + i)));
        }
        for (int i = 0; i < 5; i++){
            components.add(new ComponentInfo(1000 + i, String.format("component description %d", 1000 + i)));
        }
    }

    public ComponentInfo getComponentInfo(int id){

        // Предусловие
        if (id <= 0)
            throw new RuntimeException("Некорректный номер детали.");
        if (String.valueOf(id).length() < 6)
            throw new RuntimeException("Некорректный номер детали. Деталь существует, но устарела и более не выпускается.");

        // Выполнение основного цикла подпрограммы
        ComponentInfo componentInfo = null;
        for (ComponentInfo component : components){
            if (component.getId() == id) {
                componentInfo = component;
                break;
            }
        }

        //Постусловие
        if (componentInfo == null)
            throw new RuntimeException("Деталь не найдена.");

        return componentInfo;
    }

}

class DealerProviderV1{

    private final FactoryProviderV1 factoryProviderV1;

    public DealerProviderV1(FactoryProviderV1 factoryProviderV1){
        this.factoryProviderV1 = factoryProviderV1;
    }

    public ComponentInfo getComponent(int id){

        // Предусловие .....



        //......

        //TODO:  В рамках контрактного программирования, мы не проверяем ПЕРЕДАВАЕМЫЕ (в другой модуль) данные
        /*if(id <= 0 || String.valueOf(id).length() < 6)
            throw new RuntimeException("Некорректный номер детали.");*/
        ComponentInfo component = factoryProviderV1.getComponentInfo(id);

        // Постусловие ...
        if (component == null){
            throw new RuntimeException("Деталь не найдена.");
        }

        return component;

    }


}