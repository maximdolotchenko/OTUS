package com.otus;

/**
 * @author MDolotchenko
 */
public class CantUpdateDataException extends RuntimeException{
    public static final String MSG = "User with id={} can't update data for id={}";
    public CantUpdateDataException(String id, String idupdatable) {
        super(String.format(MSG, id, idupdatable));
    }
}
