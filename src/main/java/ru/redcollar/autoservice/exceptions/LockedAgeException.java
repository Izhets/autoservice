package ru.redcollar.autoservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LockedAgeException extends RuntimeException{

    public LockedAgeException(){
        super("Извините, чтобы продолжить вам должно быть 18!");
    }

}
