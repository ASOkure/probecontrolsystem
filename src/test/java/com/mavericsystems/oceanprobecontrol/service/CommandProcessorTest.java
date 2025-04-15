package com.mavericsystems.oceanprobecontrol.service;

import com.mavericsystems.oceanprobecontrol.exception.ObstacleException;
import com.mavericsystems.oceanprobecontrol.model.Direction;
import com.mavericsystems.oceanprobecontrol.model.Grid;
import com.mavericsystems.oceanprobecontrol.model.Position;
import com.mavericsystems.oceanprobecontrol.model.Probe;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CommandProcessorTest {

    private final CommandProcessor processor = new CommandProcessor();

    @Test
    void testCommandProcessing() {
        Grid grid = new Grid(5, 5, Set.of(new Position(2, 2)));
        Probe probe = new Probe(new Position(0, 0), Direction.NORTH);

        List<Character> commands = List.of('F', 'R', 'F'); // Move North, turn East, move East
        processor.processCommands(grid, probe, commands);

        assertEquals(new Position(1, 1), probe.getCurrentPosition());
        assertEquals(Direction.EAST, probe.getDirection());
        assertTrue(probe.getVisitedPositions().contains(new Position(1, 1)));
    }

    @Test
    void testAvoidObstacle() {
        Grid grid = new Grid(5, 5, Set.of(new Position(0, 1)));
        Probe probe = new Probe(new Position(0, 0), Direction.NORTH);

        ObstacleException ex = assertThrows(ObstacleException.class, () ->
                processor.processCommands(grid, probe, List.of('F'))
        );

        assertEquals("Obstacle at Position[x=0, y=1]", ex.getMessage());
        assertEquals(new Position(0, 0), probe.getCurrentPosition());
    }
}
