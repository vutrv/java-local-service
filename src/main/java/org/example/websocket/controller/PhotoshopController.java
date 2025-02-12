package org.example.websocket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/photoshop")
@CrossOrigin(origins = "*")
public class PhotoshopController {
    @PostMapping("/open")
    public ResponseEntity<?> openPhotoshop() {
        try {
            List<String> command = List.of("C:\\Program Files\\Adobe\\Adobe Photoshop 2025\\Photoshop.exe");
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.start();
            return ResponseEntity.ok().body("{\"message\": \"Photoshop is opening...\"}");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to open Photoshop\"}");
        }
    }
}
