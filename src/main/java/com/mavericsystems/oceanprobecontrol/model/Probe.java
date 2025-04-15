package com.mavericsystems.oceanprobecontrol.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Probe {

    private Position position;
    private Direction direction;
    private final Set<Position> visited = new LinkedHashSet<>();

    public Probe(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
        visited.add(position);
    }

    public void moveForward() {
        position = position.move(direction);
        visited.add(position);
    }

    public void moveBackward() {
        position = position.move(direction.turnLeft().turnLeft());
        visited.add(position);
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public Position getCurrentPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public Set<Position> getVisitedPositions() {
        return visited;
    }

}
