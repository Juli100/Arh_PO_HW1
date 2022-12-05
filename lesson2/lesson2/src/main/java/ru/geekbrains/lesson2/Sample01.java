package ru.geekbrains.lesson2;

import java.util.ArrayList;
import java.util.Scanner;

public class Sample01 {

    public static String data =
            "У лукоморья дуб зелёный\n" +
            "Златая цепь на дубе том:\n" +
            "И днём и ночью кот учёный\n" +
            "Всё ходит по цепи кругом;\n";
            /*"""
            У лукоморья дуб зелёный;
            Златая цепь на дубе том:
            И днём и ночью кот учёный
            Всё ходит по цепи кругом;
            Идёт направо — песнь заводит,
            Налево — сказку говорит.
            Там чудеса: там леший бродит,
            Русалка на ветвях сидит;
            Там на неведомых дорожках
            Следы невиданных зверей;
            Избушка там на курьих ножках
            Стоит без окон, без дверей;
            Там лес и дол видений полны;
            Там о заре прихлынут волны
            На брег песчаный и пустой,
            И тридцать витязей прекрасных
            Чредой из вод выходят ясных,
            И с ними дядька их морской;
            Там королевич мимоходом
            Пленяет грозного царя;
            Там в облаках перед народом
            Через леса, через моря
            Колдун несёт богатыря;
            В темнице там царевна тужит,
            А бурый волк ей верно служит;
            Там ступа с Бабою Ягой
            Идёт, бредёт сама собой,
            Там царь Кащей над златом чахнет;
            Там русский дух… там Русью пахнет!
            И там я был, и мёд я пил;
            У моря видел дуб зелёный;
            Под ним сидел, и кот учёный
            Свои мне сказки говорил.
            """;*/

    public static void main(String[] args) {
            LogReader logReader = new PoemReader(data);
             for(LogEntry log : logReader.readLogEntry()){
                 System.out.println(log.getText());
             }
    }

}

/**
 * Запись (Entry) лога
 */
class LogEntry{

    private String text;


    public String getText() {
        return text;
    }

    public LogEntry(String text) {
        this.text = text;
    }
}

abstract class LogReader{

    public abstract Object getDataSource();

    public  abstract void setDatasource(Object data);

    private Integer currentPosition = 0;

    public Integer getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Integer currentPosition) {
        this.currentPosition = currentPosition;
    }


    public Iterable<LogEntry> readLogEntry(){

        ArrayList<LogEntry> logList = new ArrayList<>();

        for (String s:  readEntries(currentPosition)) {
            logList.add(parseLogEntry(s));
        }
        return logList;
    }

    protected abstract Iterable<String> readEntries(Integer position);
    protected  abstract LogEntry parseLogEntry(String stringEntry);
}

class PoemReader extends LogReader{

    private String data;

    @Override
    public Object getDataSource() {
        return data;
    }

    @Override
    public void setDatasource(Object data) {
        this.data = data.toString();
    }

    public void setData(String data) {
        this.data = data;
    }

    public  PoemReader(){

    }

    public PoemReader(String data) {
        this.data = data;
    }



    @Override
    protected Iterable<String> readEntries(Integer position) {
        Scanner scanner = new Scanner(data);
        ArrayList<String> logList = new ArrayList<>();
        int counter = 0;
        while (scanner.hasNextLine()){
            counter++;
            if (counter >= position){
                position = counter;
                String line = scanner.nextLine();
                logList.add(line);
            }
            else{
                scanner.nextLine();
            }
        }

        return logList;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return new LogEntry(stringEntry);
    }
}

