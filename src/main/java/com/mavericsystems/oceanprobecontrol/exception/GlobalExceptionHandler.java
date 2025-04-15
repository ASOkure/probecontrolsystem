package com.mavericsystems.oceanprobecontrol.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObstacleException.class)
    public ResponseEntity<String> handleObstacle(ObstacleException e) {
        return ResponseEntity.badRequest().body("Obstacle encountered: " + e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArg(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body("Invalid command: " + e.getMessage());
    }
}
