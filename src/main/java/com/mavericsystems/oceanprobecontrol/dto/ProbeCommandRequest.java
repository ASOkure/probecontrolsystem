package com.mavericsystems.oceanprobecontrol.dto;

import com.mavericsystems.oceanprobecontrol.model.Direction;

import java.util.List;

public class ProbeCommandRequest {

    public int startX;
    public int startY;
    public Direction startDirection;
    public List<Character> commands;
}
