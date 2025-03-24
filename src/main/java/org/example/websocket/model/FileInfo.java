package org.example.websocket.model;

import lombok.Data;

@Data
public class FileInfo {
    private long fileId;
    private String fileName;
    private long size;
    private long downloaded;
    private String folderName;
}
