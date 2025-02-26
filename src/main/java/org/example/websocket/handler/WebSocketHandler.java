package org.example.websocket.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.websocket.model.ClientMessage;
import org.example.websocket.model.StatusMessage;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private static final int MAX_SESSIONS = 100;
    private static final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void afterConnectionEstablished(@NonNull WebSocketSession session) throws Exception {
        if (sessions.size() > MAX_SESSIONS) {
            session.close(CloseStatus.SESSION_NOT_RELIABLE);
            System.out.println("Connection rejected. Max session limit reached");
            return;
        }
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(@NonNull WebSocketSession session, TextMessage message) throws IOException {
        String payload = message.getPayload();
        System.out.println("Received: " + payload);

        try {
            ClientMessage clientMessage = objectMapper.readValue(payload, ClientMessage.class);
            if ("open_photoshop".equalsIgnoreCase(clientMessage.getAction())) {
                boolean success = openPhotoshop();
                StatusMessage response = new StatusMessage(
                        "photoshop",
                        success ? "success" : "error",
                        success ? "Photoshop is opening..." : "Failed to open Photoshop"
                );

                String responseJson = objectMapper.writeValueAsString(response);
                session.sendMessage(new TextMessage(responseJson));
            } else {
                StatusMessage response = new StatusMessage(
                        "communication_message",
                        "success",
                        "Received action: " + message);
                broadcastMessage(response);
            }
        } catch (IOException e) {
            session.sendMessage(new TextMessage("{\"type\": \"error\", \"status\": \"error\", \"message\": \"Invalid request format\"}"));
        }
    }

    private boolean openPhotoshop() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("C:\\Program Files\\Adobe\\Adobe Photoshop 2025\\Photoshop.exe");
            processBuilder.start();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void broadcastMessage(StatusMessage message) {
        String jsonMessage;
        try {
            jsonMessage = objectMapper.writeValueAsString(message);
        } catch (IOException e) {
            System.err.println("Failed to serialize message: " + e.getMessage());
            return;
        }

        for (WebSocketSession session : sessions) {
            if (session.isOpen()) {
                try {
                    session.sendMessage(new TextMessage(jsonMessage));
                } catch (IOException e) {
                    System.err.println("Failed to send message: " + e.getMessage());
                }
            }
        }
    }

    @Override
    public void afterConnectionClosed(@NonNull WebSocketSession session, @NonNull CloseStatus status) {
        sessions.remove(session);
    }

    public static CopyOnWriteArrayList<WebSocketSession> getSessions() {
        return sessions;
    }
}
