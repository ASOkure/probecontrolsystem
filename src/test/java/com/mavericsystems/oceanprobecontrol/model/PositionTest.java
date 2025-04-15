package com.mavericsystems.oceanprobecontrol.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.swing.text.Position;

public class PositionTest {

    @Test
    void testMoveForward() {
        Position start = new Position(0, 0);
        assertEquals(new Position(0, 1), start.move(Direction.NORTH));
        assertEquals(new Position(1, 0), start.move(Direction.EAST));
    }
}
