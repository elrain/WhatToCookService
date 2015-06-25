package com.elrain.whattocook.exceptions;

/**
 * Created by elrain on 23.06.15.
 */
public class IntegerException {
    private int code;

    public IntegerException(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
