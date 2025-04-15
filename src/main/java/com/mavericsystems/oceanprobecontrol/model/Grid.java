package com.mavericsystems.oceanprobecontrol.model;

import java.util.Set;

public class Grid {

    private final int width;
    private final int height;
    private final Set<Position> obstacles;

    public Grid(int width, int height, Set<Position> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    public boolean isWithinBounds(Position p) {
        return p.x() >= 0 && p.x() < width && p.y() >= 0 && p.y() < height;
    }

    public boolean isObstacle(Position p) {
        return obstacles.contains(p);
    }


}
