package org.example.websocket.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MinIOCredentialsResponse {
    private String endPoint;
    private String accessKeyId;
    private String secretKey;
    private String sessionToken;
    private Integer concurrentThreads;
    private Integer maxConnections;
    private Boolean allowMultipartUpload;
    private String expiration;
}
