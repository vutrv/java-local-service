package org.example.websocket.service;

import org.example.websocket.commands.StartDownloadCommand;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    public StartDownloadCommand handleDownload(StartDownloadCommand command) {
        System.out.println("Download job started for: " + command.getJobsInfo());
        return command;
    }
}
