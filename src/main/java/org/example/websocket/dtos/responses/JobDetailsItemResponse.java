package org.example.websocket.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDetailsItemResponse {
    private String description;
    private String detailsUrl;
    private List<JobRejectionDetailsItemResponse> jobRejectionDetails;
}
