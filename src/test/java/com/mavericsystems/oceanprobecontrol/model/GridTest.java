package com.mavericsystems.oceanprobecontrol.model;

import org.junit.jupiter.api.Test;

import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    @Test
    void testPositionWithinBounds() {
        Grid grid = new Grid(5, 5, Set.of());
        assertTrue(grid.isWithinBounds(new Position(2, 2)));
        assertFalse(grid.isWithinBounds(new Position(6, 6)));
    }

    @Test
    void testObstacleDetection() {
        Grid grid = new Grid(5, 5, Set.of(new Position(1, 1)));
        assertTrue(grid.isObstacle(new Position(1, 1)));
        assertFalse(grid.isObstacle(new Position(0, 0)));
    }
}
