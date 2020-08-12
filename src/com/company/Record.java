package com.company;

import java.util.Objects;

public class Record implements Cloneable, Comparable<Record> {
    public long id;
    private String FIO;
    private String bornDate;
    private String numbers;
    private String address;
    private long timeCreateFields;

    public Record() {
    }

    public Record(long id, String FIO, String bornDate, String numbers, String address, long timeCreateFields) {
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

    public String getNumbers() {
        return numbers;
    }

    public String getAddress() {
        return address;
    }

    public long getTimeCreateFields() {
        return timeCreateFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record)) return false;
        Record record = (Record) o;
        return getId() == record.getId() &&
                getTimeCreateFields() == record.getTimeCreateFields() &&
                Objects.equals(getFIO(), record.getFIO()) &&
                Objects.equals(getBornDate(), record.getBornDate()) &&
                Objects.equals(getNumbers(), record.getNumbers()) &&
                Objects.equals(getAddress(), record.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFIO(), getBornDate(), getNumbers(), getAddress(), getTimeCreateFields());
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", FIO='" + FIO + '\'' +
                ", bornDate='" + bornDate + '\'' +
                ", numbers='" + numbers + '\'' +
                ", address='" + address + '\'' +
                ", timeCreateFields=" + timeCreateFields +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Record o) {
        return (int) (this.id - o.getId());

    }

}
