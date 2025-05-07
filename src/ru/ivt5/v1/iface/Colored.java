package ru.ivt5.v1.iface;
import ru.ivt5.v1.colors.Color;
import ru.ivt5.v1.colors.ColorException;

public interface Colored {
    int getColor();
    void setColor(int color);

    //void setColor(String colorString) throws ColorException;
    //void setColor(Color color);
    //Color getColor();
}
