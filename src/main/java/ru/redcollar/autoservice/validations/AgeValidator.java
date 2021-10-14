package ru.redcollar.autoservice.validations;

import ru.redcollar.autoservice.exceptions.LockedAgeException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class AgeValidator {

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

        long daysBetween = ChronoUnit.DAYS.between(twoDate, firstDate);
        System.out.println(daysBetween/365);
        if (daysBetween/365 < 18){
            throw new LockedAgeException();
        }

    }
}