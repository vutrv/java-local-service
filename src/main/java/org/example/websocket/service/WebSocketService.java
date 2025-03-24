package org.example.websocket.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ultis.FileUltis;
import org.example.websocket.handler.WebSocketHandler;
import org.example.websocket.model.FileInfo;
import org.example.websocket.model.StatusMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Service
public class WebSocketService {
    private final WebSocketHandler webSocketHandler;
    private final ScheduledExecutorService scheduler;
    private ScheduledFuture<?> scheduledTask;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public WebSocketService(WebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
        this.scheduler = Executors.newScheduledThreadPool(2);
    }

    public void sendMessage(String message) throws IOException {
        for (WebSocketSession session : webSocketHandler.getSessions()) {
            if (session.isOpen()) {
                session.sendMessage(new TextMessage(message));
            }
        }
    }

    @Scheduled(fixedRate = 2000)
    public void sendPeriodicMessages() {
        webSocketHandler.broadcastMessage(new StatusMessage(
                "Automate message",
                "success",
                "Automated server message at: " + System.currentTimeMillis()
        ));
    }

    public void startJobUpdates() {
        if (scheduledTask != null && !scheduledTask.isCancelled()) {
            return;
        }

        scheduledTask = scheduler.scheduleAtFixedRate(() -> {
            try {
                FileInfo mockFile = FileUltis.generateMockFile();
                webSocketHandler.broadcastMessage(new StatusMessage(
                        "file_info",
                        "success",
                        "Mock file generated: " + mockFile.getFileName()
                ));
            } catch (Exception e) {
                System.err.println("Error broadcasting mock file: " + e.getMessage());
                e.printStackTrace();
            }

        }, 0, 3, TimeUnit.SECONDS);
    }

    public void stopJobUpdates() {
        if (scheduledTask != null && !scheduledTask.isCancelled()) {
            scheduledTask.cancel(false);
        }
    }

    public void shutdownScheduler() {
        scheduler.shutdown();
    }
}
