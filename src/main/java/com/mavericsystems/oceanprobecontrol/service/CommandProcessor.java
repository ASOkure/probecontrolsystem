package com.mavericsystems.oceanprobecontrol.service;

import com.mavericsystems.oceanprobecontrol.exception.ObstacleException;
import com.mavericsystems.oceanprobecontrol.model.Grid;
import com.mavericsystems.oceanprobecontrol.model.Position;
import com.mavericsystems.oceanprobecontrol.model.Probe;

import java.util.List;

public class CommandProcessor {

    private final Grid grid;

    public CommandProcessor(Grid grid) {
        this.grid = grid;
    }

    public void processCommands(Probe probe, List<Character> commands) {
        for (char command : commands) {
            switch (command) {
                case 'F' -> tryMove(probe, true);
                case 'B' -> tryMove(probe, false);
                case 'L' -> probe.turnLeft();
                case 'R' -> probe.turnRight();
                default -> throw new IllegalArgumentException("Unknown command: " + command);
            }
        }
    }

    private void tryMove(Probe probe, boolean forward) {
        Position nextPos = forward
                ? probe.getCurrentPosition().move(probe.getDirection())
                : probe.getCurrentPosition().move(probe.getDirection().turnLeft().turnLeft());

        if (!grid.isWithinBounds(nextPos)) return;
        if (grid.isObstacle(nextPos)) throw new ObstacleException("Obstacle at " + nextPos);

        if (forward) probe.moveForward();
        else probe.moveBackward();
    }
}
