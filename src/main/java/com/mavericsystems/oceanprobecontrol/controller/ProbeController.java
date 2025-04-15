package com.mavericsystems.oceanprobecontrol.controller;

import com.mavericsystems.oceanprobecontrol.dto.ProbeCommandRequest;
import com.mavericsystems.oceanprobecontrol.dto.ProbeCommandResponse;
import com.mavericsystems.oceanprobecontrol.model.Grid;
import com.mavericsystems.oceanprobecontrol.model.Position;
import com.mavericsystems.oceanprobecontrol.model.Probe;
import com.mavericsystems.oceanprobecontrol.service.CommandProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@RestController
@RequestMapping("/api/probe")
public class ProbeController {

    private final CommandProcessor processor;

    public ProbeController(CommandProcessor processor) {
        this.processor = processor;
    }

    @PostMapping("/command")
    public ResponseEntity<ProbeCommandResponse> controlProbe(@RequestBody ProbeCommandRequest request) {
        Grid grid = new Grid(
                request.gridWidth,
                request.gridHeight,
                Set.copyOf(request.obstacles)
        );

        Probe probe = new Probe(new Position(request.startX, request.startY), request.startDirection);

        processor.processCommands(grid, probe, request.commands);

        return ResponseEntity.ok(new ProbeCommandResponse(probe.getCurrentPosition(), probe.getVisitedPositions()));
    }
}
