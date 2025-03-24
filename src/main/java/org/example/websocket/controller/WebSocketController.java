package org.example.websocket.controller;

import org.example.websocket.model.Job;
import org.example.websocket.service.JobService;
import org.example.websocket.service.WebSocketService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/ws")
public class WebSocketController {
    private final WebSocketService webSocketService;
    private final JobService jobService;

    public WebSocketController(WebSocketService webSocketService, JobService jobService) {
        this.webSocketService = webSocketService;
        this.jobService = jobService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) throws IOException {
        webSocketService.sendMessage(message);
        return "Message send: " + message;
    }
}
