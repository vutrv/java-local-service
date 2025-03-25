package org.example.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class WebSocketController {

    @MessageMapping("/start-download")  // Clients send here: "/app/jobs/download"
    @SendTo("/topic/jobs/download")    // Broadcast to subscribers
    public Map<String, Object> handleClientMessage(Map<String, Object> message) {
        System.out.println("Received message from client: " + message);
        return message;
    }
}