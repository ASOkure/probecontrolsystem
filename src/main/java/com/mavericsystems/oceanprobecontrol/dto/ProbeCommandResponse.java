package com.mavericsystems.oceanprobecontrol.dto;

import com.mavericsystems.oceanprobecontrol.model.Position;

import java.util.Set;

public class ProbeCommandResponse {

    public Position finalPosition;
    public Set<Position> visitedPositions;

    public ProbeCommandResponse(Position finalPosition, Set<Position> visitedPositions) {
        this.finalPosition = finalPosition;
        this.visitedPositions = visitedPositions;
    }
}
