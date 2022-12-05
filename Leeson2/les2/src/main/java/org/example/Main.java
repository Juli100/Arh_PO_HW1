package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}




class LogEntry{

    private String text;

    public String getText() {
        return text;
    }

    public LogEntry(String text){
        this.text = text;
    }
}

abstract class LogReader{

    private Integer currentPosition = 0;

    public Integer getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Integer currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Iterable<LogEntry> readLogEntries(){
        ArrayList<LogEntry> logList = new ArrayList<LogEntry>();

        for (String s: readEntries(currentPosition)){
            logList.add(parseLogEntry(s));
        }

        return logList;
    }

    protected abstract Iterable<String> readEntries (Integer Position)
}

class PoemReader extends LogReader{

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public PoemReader(){

    }

    public PoemReader(String data){
        this.data = data;
    }
    @Override
    protected Iterable<String> readEntries(Integer Position) {
        Scanner scanner = new Scanner(data);
        ArrayList<String> logList = new ArrayList<>();
        int counter = 0;
        while (scanner.hasNextLine()){
            counter++;
            if (counter >= position){
                position = counter;

            }
        }
    }

    @Override
    protected LogEntry parseLogEntries() {
        return super.readLogEntries();
    }
}