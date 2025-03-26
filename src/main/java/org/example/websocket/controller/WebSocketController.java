package org.example.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class WebSocketController {

    @MessageMapping("/start-download-command")  // Clients send here: "/app/start-download-command"
    @SendTo("/topic/start-download-command")    // Broadcast to subscribers
    public String handleClientMessage() {
        String message = "Received Command: Start-Download_Command from client";
        System.out.println(message);
        return message;
    }
}