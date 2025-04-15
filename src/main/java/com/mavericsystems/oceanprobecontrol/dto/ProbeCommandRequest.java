package com.mavericsystems.oceanprobecontrol.dto;

import com.mavericsystems.oceanprobecontrol.model.Direction;
import com.mavericsystems.oceanprobecontrol.model.Position;

import java.util.List;

public class ProbeCommandRequest {
    public int startX;
    public int startY;
    public Direction startDirection;
    public List<Character> commands;


    public Integer gridWidth = 10;
    public Integer gridHeight = 10;
    public List<Position> obstacles = List.of();
}

