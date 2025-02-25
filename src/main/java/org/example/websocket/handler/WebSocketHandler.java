package org.example.websocket.handler;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private static final int MAX_SESSIONS = 100;
    private static final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

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

        for (WebSocketSession s: sessions) {
            if (s.isOpen()) {
                s.sendMessage(new TextMessage("Server response: " + payload));
            }
        }
    }

    public void sendMessageToAll(String message) {
        for (WebSocketSession session : sessions) {
            if (session.isOpen()) {
                try {
                    session.sendMessage(new TextMessage(message));
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
