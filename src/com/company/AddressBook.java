package com.company;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AddressBook {
    public Map<Long, Record> records = new HashMap<>();
    private long nextId;

    private long getNextId() {
        if (nextId < Long.MAX_VALUE && !records.containsKey(nextId))
            return nextId++;
        nextId = 0;
        while (nextId < Long.MAX_VALUE) {
            if (!records.containsKey(nextId))
                return nextId;
            ++nextId;
        }

        return 0;
    }

    public Record addRecord(String FIO, String bornDate, int numbers, String address, long timeCreateFields) throws CloneNotSupportedException {
        long recordId = getNextId();
        Record record = new Record(recordId, FIO, bornDate, numbers, address, timeCreateFields);
        records.put(recordId, record);
        return (Record) record.clone();
    }

    public Record getRecord(long id) throws CloneNotSupportedException {
        if (records.containsKey(id)) {
            return (Record) records.get(id).clone();
        }
        return null;
    }

    public Record updateRecord(long id, String FIO, String bornDate, int numbers, String address, long timeCreateField) throws CloneNotSupportedException {
        long timeCreateFields = 0;
        Record record = new Record(id, FIO, bornDate, numbers, address, timeCreateFields);
        records.put(id, record);
        return getRecord(id);
    }

    public void removeRecord(long id) {
        records.remove(id);
    }

    public List<Record> allRecords() {
        List<Record> result = new ArrayList<Record>();
        for (Record record : this.records.values())
            result.add(record);
        return result;
    }


    public Object objectToJson(Object object) {
        Gson gson = new Gson(); //GsonBuilder().setPrettyPrinting().create()
        String json = gson.toJson(object);
        return json;
    }


    public Map<Long, Record> fromJsonToMap(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json,new TypeToken<Map<Long, Record>>(){}.getType());

    }


    public void fileWriter(String json) throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\pbTask\\HW10\\src\\com\\company\\file.json");
        fileWriter.write(json);
        fileWriter.close();
    }

    public String fileReader() throws IOException {
        FileReader fileReader = new FileReader("C:\\pbTask\\HW10\\src\\com\\company\\file.json");
        StringBuilder stringBuilder = new StringBuilder();
        char[] readFile = new char[1000];
        fileReader.read(readFile); // запись с файла в буффер

        for (char c : readFile)
            stringBuilder.append(c);
        fileReader.close();
        return stringBuilder.toString();
    }
}
