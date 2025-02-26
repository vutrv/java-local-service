package org.example.websocket.model;

public class StatusMessage {
    private final String type;
    private final String status;
    private final String message;

    public StatusMessage(String type, String status, String message) {
        this.type = type;
        this.status = status;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
