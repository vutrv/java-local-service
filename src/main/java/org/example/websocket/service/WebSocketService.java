package org.example.websocket.service;

import org.example.websocket.handler.WebSocketHandler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import java.io.IOException;

@Service
public class WebSocketService {
    private final WebSocketHandler webSocketHandler;

    public WebSocketService(WebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }

    public void sendMessage(String message) throws IOException {
        for (WebSocketSession session: WebSocketHandler.getSessions()) {
            if (session.isOpen()) {
                session.sendMessage(new TextMessage(message));
            }
        }
    }

    @Scheduled(fixedRate = 2000)
    public void sendPeriodicMessages() {
        webSocketHandler.sendMessageToAll("Automated server message at: " + System.currentTimeMillis());
    }
}
