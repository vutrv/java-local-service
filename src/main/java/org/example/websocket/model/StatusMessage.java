package org.example.websocket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StatusMessage {
    private final String type;
    private final String status;
    private final String message;
}
