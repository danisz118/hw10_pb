package com.company;

import java.util.Map;
import java.util.Objects;

public class Record implements Cloneable {
    public long id;
    private String FIO;
    private String bornDate;
    private int numbers;
    private String address;
    private long timeCreateFields;

    public Record() {
    }

    public Record(long id, String FIO, String bornDate, int numbers, String address, long timeCreateFields) {
        this.id = id;
        this.FIO = FIO;
        this.bornDate = bornDate;
        this.numbers = numbers;
        this.address = address;
        this.timeCreateFields = timeCreateFields;
    }



    public long getId() {
        return id;
    }

    public String getFIO() {
        return FIO;
    }

    public String getBornDate() {
        return bornDate;
    }

    public int getNumbers() {
        return numbers;
    }

    public String getAddress() {
        return address;
    }

    public long getTimeCreateFields() {
        return timeCreateFields;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", FIO='" + FIO + '\'' +
                ", bornDate='" + bornDate + '\'' +
                ", numbers=" + numbers +
                ", address='" + address + '\'' +
                ", timeCreateFields=" + timeCreateFields +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record)) return false;
        Record record = (Record) o;
        return getId() == record.getId() &&
                getNumbers() == record.getNumbers() &&
                getTimeCreateFields() == record.getTimeCreateFields() &&
                Objects.equals(getFIO(), record.getFIO()) &&
                Objects.equals(getBornDate(), record.getBornDate()) &&
                Objects.equals(getAddress(), record.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFIO(), getBornDate(), getNumbers(), getAddress(), getTimeCreateFields());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
