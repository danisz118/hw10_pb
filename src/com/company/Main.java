package com.company;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class Main {

    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        AddressBook addressBook = new AddressBook();

        Date date = new Date();
        Scanner scanner = new Scanner(System.in);

        addressBook.addRecord(1L,"Денис", "25.01.94", "063043", "ул. Ленина, 3", date.getTime());
        addressBook.addRecord(40L,"Валера", "30.01.91", "0236 ","ул. Ленина, 15", date.getTime());
        addressBook.addRecord(2L,"Андрей", "25.01.45", "0145", "ул. Ленина, 63", date.getTime());




        System.out.println("Тебя приветсвует приложение \"Телефонная книга\" в котором ты сможешь добавлять записи,\n" +
                "обновлять записи, считывать записи, удалять, показать все записи телефонной книги ,\n записывать в файл и читать с файла");
        System.out.println("Для добавления записи нажми \"1\"");
        System.out.println("Обновление записи  нажми \"2\"");
        System.out.println("Показать запись которая находится под определенным id нажми \"3\" ");
        System.out.println("Удалить запись по id нажми \"4\"");
        System.out.println("Показать все записи телефонной книги нажми \"5\"");
        System.out.println("Записать в файл нажми \"6\"");
        System.out.println("Считать из файла нажми \"7\"");
        System.out.println("Вывести отсортированные по ключу значения \"8\"");
        System.out.println("Для завершения работы программы нажми любую кнокру кроме 1-8");
        while (true) {
            System.out.println("Выбери цифру соответсвующую действию 1-9 ");
            Integer string = scanner.nextInt();
            if (string.equals(1)) {
                System.out.println("Вводи в офрмате : long id, String FIO, String bornDate, Sting numbers, String address");
                addressBook.addRecord(scanner.nextLong(), scanner.nextLine(), scanner.nextLine(),scanner.nextLine(), scanner.nextLine(), date.getTime());
            }
            if (string.equals(2)) {
                System.out.println("Список всех записей к книге, выбери ту которую будешь редактировать по номеру  id");
                System.out.println(addressBook.allRecords());
                addressBook.updateRecord(scanner.nextLong(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
                System.out.println("После редактирования записи "+addressBook.allRecords());
            }
            if (string.equals(3)) {
                System.out.println(addressBook.getRecord(scanner.nextLong()));
            }

            if (string.equals(4)) {
                addressBook.removeRecord(scanner.nextLong());
            }
            if (string.equals(5)) {
                System.out.println(addressBook.allRecords());
            }
            if (string.equals(6)) {
                addressBook.store();
            }
            if (string.equals(7)) {
                addressBook.read();
            }
            if (string.equals(8)) {
                addressBook.sortByKey();
            }
            else  break;
        }
    }
}
