package ru.geekbrains.lesson4;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class Sample01 {

    public static void main(String[] args) {

    }

}

class FileService implements Readable{

    private ArrayList<String> lines;



    public Collection<String> readTextFile(File file){

        //Предусловие
        if (file.exists()) {
            if (file.length() > 5000){
                throw new RuntimeException("Размер файла более 5мб. Чтение файла запрещено.");
            }
        }

        // Выполнение основного кода ...
        try {
            //...
            //...
            lines = new ArrayList<>();
        }
        catch (Exception e){

        }

        //Постусловие
        if (lines == null)
            throw new RuntimeException("Ошибка чтения файла.");

        //Инвариант
        validateResult(lines);


        return lines;

    }

    private void validateResult(Collection<String> res){
        if (res.size() == 0){
            throw new RuntimeException("Файл пуст.");
        }
    }

}

class Module1 implements Readable{

    @Override
    public Collection<String> readTextFile(File file) {
        return null;
    }
}

interface Readable{

    /**
     * Считывание строк из текстового файла
     * @param file файл
     * @throws RuntimeException исключения при работе с файлом
     * @return коллекция строк
     */
    Collection<String> readTextFile(File file);

}


