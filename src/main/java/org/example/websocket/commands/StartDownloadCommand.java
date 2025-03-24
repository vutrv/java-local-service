package org.example.websocket.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.websocket.dtos.responses.JobsInformationResourceResponse;
import org.example.websocket.dtos.responses.MinIOCredentialsResponse;
import org.example.websocket.model.BaseStompMessage;
import org.example.websocket.model.UserProfile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StartDownloadCommand extends BaseStompMessage {
    private JobsInformationResourceResponse jobsInfo;
    private MinIOCredentialsResponse credentials;
    private UserProfile userProfile;

    public StartDownloadCommand(String topic, JobsInformationResourceResponse jobsInfo,
                                MinIOCredentialsResponse credentials, UserProfile userProfile) {
        super(topic);
        this.jobsInfo = jobsInfo;
        this.credentials = credentials;
        this.userProfile = userProfile;
    }
}
