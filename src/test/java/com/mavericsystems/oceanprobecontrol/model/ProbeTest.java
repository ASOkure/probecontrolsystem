package com.mavericsystems.oceanprobecontrol.model;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbeTest {

    @Test
    void testInitialPositionAndMove() {
        Probe probe = new Probe(new Position(0, 0), Direction.NORTH);
        probe.moveForward();
        assertEquals(new Position(0, 1), probe.getCurrentPosition());
    }

    @Test
    void testTurning() {
        Probe probe = new Probe(new Position(0, 0), Direction.NORTH);
        probe.turnRight();
        assertEquals(Direction.EAST, probe.getDirection());
    }

    @Test
    void testVisitedPositions() {
        Probe probe = new Probe(new Position(0, 0), Direction.NORTH);
        probe.moveForward();
        probe.turnRight();
        probe.moveForward();
        Set<Position> visited = probe.getVisitedPositions();
        assertEquals(3, visited.size()); // includes start
    }
}
