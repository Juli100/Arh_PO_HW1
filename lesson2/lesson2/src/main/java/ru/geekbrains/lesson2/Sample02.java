package ru.geekbrains.lesson2;

public class Sample02 {

    public static void main(String[] args) {

        LogReader poemReader = new ConcreteReaderCreator()
                .createLogReader(LogType.Poem);
        poemReader.setDatasource(Sample01.data);

        for(LogEntry log : poemReader.readLogEntry()){
            System.out.println(log.getText());
        }

    }

}

enum LogType{
    Text,
    Poem,
    Database,
    System
}

abstract class BaseLogReaderCreator{

    public LogReader createLogReader(LogType logType){
        return createLogReaderInstance(logType);
    }

    protected abstract LogReader createLogReaderInstance(LogType logType);

}

class ConcreteReaderCreator extends BaseLogReaderCreator{

    @Override
    protected LogReader createLogReaderInstance(LogType logType) {

        switch (logType){
            case Poem:
                return new PoemReader();
            case Text:
                return new TextFileReader();
            case Database:
                return new DatabaseReader();
            case System:
                return new OperationSystemLogEventsReader();
        }
        return  null;
        /*return switch (logType){
            case Poem -> new PoemReader();
            case Text -> new TextFileReader();
            case Database -> new DatabaseReader();
            case System -> new OperationSystemLogEventsReader();
        };*/
    }
}

class TextFileReader extends LogReader{

    @Override
    public Object getDataSource() {
        return null;
    }

    @Override
    public void setDatasource(Object data) {

    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        return null;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return null;
    }
}

class DatabaseReader extends LogReader{

    @Override
    public Object getDataSource() {
        return null;
    }

    @Override
    public void setDatasource(Object data) {

    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        return null;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return null;
    }
}

class OperationSystemLogEventsReader extends LogReader{

    @Override
    public Object getDataSource() {
        return null;
    }

    @Override
    public void setDatasource(Object data) {

    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        return null;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return null;
    }
}