package com.mavericsystems.oceanprobecontrol.model;

import org.junit.jupiter.api.Test;

public class DirectionTest {

    @Test
    void testTurnLeft() {
        assertEquals(Direction.WEST, Direction.NORTH.turnLeft());
        assertEquals(Direction.SOUTH, Direction.WEST.turnLeft());
    }

    @Test
    void testTurnRight() {
        assertEquals(Direction.EAST, Direction.NORTH.turnRight());
        assertEquals(Direction.SOUTH, Direction.EAST.turnRight());
    }
}
