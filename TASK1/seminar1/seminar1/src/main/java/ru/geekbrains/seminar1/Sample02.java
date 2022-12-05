package ru.geekbrains.seminar1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Sample02 {

    public static void main(String[] args) {

        MyLogObserver1 myLogObserver1 = new MyLogObserver1();
        MyLogObserver2 myLogObserver2 = new MyLogObserver2();


        MyLogFileWriter myLogFileWriter = new MyLogFileWriter();
        myLogFileWriter.RegisterObserver(myLogObserver1);
        myLogFileWriter.RegisterObserver(myLogObserver2);

        myLogFileWriter.WriteString("Hello, GeekBrains!");

        myLogFileWriter.RemoveObserver(myLogObserver2);

        myLogFileWriter.WriteString("Hello, GeekBrains!");


    }

}

/**
 * Подписчик (observer - наблюдатель)
 */
class MyLogObserver1 implements FileObserver{

    @Override
    public void UpdateState() {
        System.out.println("MyLogObserver1 -> Файл был изменен ...");
    }

    @Override
    public int read() {
        return 0;
    }
}

/**
 * Подписчик (observer - наблюдатель)
 */
class MyLogObserver2 implements FileObserver{

    @Override
    public void UpdateState() {
        System.out.println("MyLogObserver2 -> Файл был изменен ...");
    }

    @Override
    public int read() {
        return 0;
    }
}

/**
 * Интерфейс наблюдателя
 */
interface FileObserver{
    void UpdateState();

    int read();
}

class MyLogFileWriter implements  FileChanger{

    private static Collection<FileObserver> _observers = new ArrayList<>();


    public static void WriteString(String args) {


        //TODO: Обратились к файлу, совершили запись в файл ...
        FileChanger.NotifyAll();
    }

    @Override
    public void RegisterObserver(FileObserver o) {
        _observers.add(o);
    }

    @Override
    public void RemoveObserver(FileObserver o) {
        _observers.remove(o);
    }

}

interface FileChanger{
    void RegisterObserver(FileObserver o);
    void RemoveObserver(FileObserver o);

    static void NotifyAll() {

    }
}