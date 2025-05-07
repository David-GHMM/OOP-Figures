package ru.ivt5.v1.colors;

public enum ColorErrorCode {
    WRONG_COLOR_STRING,
    NULL_COLOR;

    String errorString;
    //"Вы написали некорректное значение для цвета, корректыми будут: RED, BLUE, GREEN"

    ColorErrorCode(String errorString){
        this.errorString = errorString;
    }

    ColorErrorCode() {

    }

    public String getErrorString(){
        return errorString;
    }

}
