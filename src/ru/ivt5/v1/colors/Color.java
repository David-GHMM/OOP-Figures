package ru.ivt5.v1.colors;

public enum Color {
    RED,
    GREEN,
    BLUE;


    public static Color colorFromString(String colorString) throws ColorException {
        return switch (colorString) {
            case "RED" -> Color.RED;
            case "GREEN" -> Color.GREEN;
            case "BLUE" -> Color.BLUE;
            default -> throw new ColorException(ColorErrorCode.WRONG_COLOR_STRING);
        };
    }
}
