package org.example.websocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WebSocketService {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Scheduled(fixedRate = 5000)
    public  void sendTestMessage() {
        String topic = "/topic/jobs/download";
        Map<String, Object> payload = Map.of("topic", topic, "object", "Test Message");

        messagingTemplate.convertAndSend(topic, payload);
        System.out.println("Sent message to " + topic);
    }

}
