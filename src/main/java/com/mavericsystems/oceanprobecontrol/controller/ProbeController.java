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
    private final Grid grid;

    public ProbeController() {

        this.grid = new Grid(10, 10, Set.of(new Position(2, 2)));
        this.processor = new CommandProcessor(grid);
    }

    @PostMapping("/command")
    public ResponseEntity<ProbeCommandResponse> controlProbe(@RequestBody ProbeCommandRequest request) {
        Probe probe = new Probe(new Position(request.startX, request.startY), request.startDirection);
        processor.processCommands(probe, request.commands);
        return ResponseEntity.ok(new ProbeCommandResponse(probe.getCurrentPosition(), probe.getVisitedPositions()));
    }

}
