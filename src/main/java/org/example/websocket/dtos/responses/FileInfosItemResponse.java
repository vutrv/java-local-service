package org.example.websocket.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileInfosItemResponse {
    private String md5;
    private String fileName;
    private String cachedLocation;
    private String minIOBucket;
    private String minIOKey;
    private Integer size;
    private Integer fileId;
    private String folderName;
    private String l2Name;
    private String cdnLocation;
    private String state;
    private String note;
}
