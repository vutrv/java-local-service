package org.example.websocket.controller;

import org.example.websocket.commands.StartDownloadCommand;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class JobController {

    private final SimpMessagingTemplate messagingTemplate;

    public JobController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // Client sends messages to "/app/startDownload"
    @MessageMapping("/startDownload")
    @SendTo("/api/jobs/download")
    public StartDownloadCommand startDownload(StartDownloadCommand command) {
        System.out.println("Received StartDownloadCommand: " + command);
        return command;
    }

    // Alternative method to send messages from the server to clients
    public void notifyClients(StartDownloadCommand command) {
        messagingTemplate.convertAndSend("/api/jobs/download", command);
    }
}

