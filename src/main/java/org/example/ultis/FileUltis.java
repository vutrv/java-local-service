package org.example.ultis;

import org.example.websocket.model.FileInfo;

import java.util.Random;

public class FileUltis {
    private static final Random random = new Random();

    public static FileInfo generateMockFile() {
        FileInfo file = new FileInfo();
        file.setFileId(random.nextInt(1000));
        file.setFileName("file_" + random.nextInt(100) + ".txt");
        file.setSize(random.nextInt(5000) + 1000);
        file.setDownloaded(random.nextInt(1000));
        file.setFolderName("folder_" + random.nextInt(10));
        return file;
    }
}
