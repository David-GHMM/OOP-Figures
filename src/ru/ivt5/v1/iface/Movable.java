package ru.ivt5.v1.iface;

import ru.ivt5.v1.Point;

public interface Movable {
    void moveTo(int x, int y);
    void moveTo(Point point);
    void moveRel(int dx, int dy);
}
