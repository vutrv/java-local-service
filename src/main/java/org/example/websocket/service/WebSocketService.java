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
    public  void sendFileDownloadProgressEvent() {
        String topic = "/topic/file-download-progress-event";
        Map<String, Object> payload = Map.of(
                "md5", "123456",
                "transferredBytes", 2097152,
                "timestamp", System.currentTimeMillis()
        );

        messagingTemplate.convertAndSend(topic, payload);
        System.out.println("Sent file-download-progress data to " + topic);
    }

    @Scheduled(fixedRate = 10000)
    public void sendFileDownnloadFailedEvent() {
        String topic = "/topic/file-download-failed-event";
        Map<String, Object> payload = Map.of(
                "md5", "123456",
                "error", Map.of(
                        "code", "500",
                        "message", "File download failed"
                ),
                "timestamp", System.currentTimeMillis()
        );

        messagingTemplate.convertAndSend(topic, payload);
        System.out.println("Sent file-download-failed data to " + topic);
    }

    @Scheduled(fixedRate = 10000)
    public void sendFileDownloadCompletedEvent() {
        String topic = "/topic/file-download-completed-event";
        Map<String, Object> payload = Map.of(
                "md5", "123456",
                "timestamp", System.currentTimeMillis()
        );

        messagingTemplate.convertAndSend(topic, payload);
        System.out.println("Sent file-download-completed data to " + topic);
    }
}
