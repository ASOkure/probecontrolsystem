package com.mavericsystems.oceanprobecontrol.service;

import com.mavericsystems.oceanprobecontrol.exception.ObstacleException;
import com.mavericsystems.oceanprobecontrol.model.Grid;
import com.mavericsystems.oceanprobecontrol.model.Position;
import com.mavericsystems.oceanprobecontrol.model.Probe;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandProcessor {
    public void processCommands(Grid grid, Probe probe, List<Character> commands) {
        for (char command : commands) {
            switch (command) {
                case 'F' -> tryMove(grid, probe, true);
                case 'B' -> tryMove(grid, probe, false);
                case 'L' -> probe.turnLeft();
                case 'R' -> probe.turnRight();
                default -> throw new IllegalArgumentException("Unknown command: " + command);
            }
        }
    }

    private void tryMove(Grid grid, Probe probe, boolean forward) {
        var nextPos = forward
                ? probe.getCurrentPosition().move(probe.getDirection())
                : probe.getCurrentPosition().move(probe.getDirection().turnLeft().turnLeft());

        if (!grid.isWithinBounds(nextPos)) return;
        if (grid.isObstacle(nextPos)) throw new ObstacleException("Obstacle at " + nextPos);

        if (forward) probe.moveForward();
        else probe.moveBackward();
    }
}


