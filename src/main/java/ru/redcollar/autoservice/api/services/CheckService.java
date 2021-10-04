package ru.redcollar.autoservice.api.services;

import ru.redcollar.autoservice.exceptions.LockedAgeException;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;

public class CheckService {

    public static LocalDate convertToEntityAttribute(java.sql.Date databaseValue) {

        return (databaseValue == null) ? null
                : databaseValue.toLocalDate();
    }

    public static void checkAge(Date dateOfBirth) throws LockedAgeException {
//        String[] s=dateOfBirth.split("[.,--]");
//        if (Integer.parseInt(s[0]) >= 2003){
//            throw new LockedAgeException("Извините, вам должно быть 18!");
//        }

        LocalDate firstDate = LocalDate.now();
        LocalDate twoDate = convertToEntityAttribute((java.sql.Date) dateOfBirth);

        long daysBetween = ChronoUnit.DAYS.between(firstDate, twoDate);
        System.out.println(daysBetween/365);
        if (daysBetween > 6){
            throw new LockedAgeException("Извините, вам должно быть 18!");
        }
    }
}