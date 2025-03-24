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
public class JobsInformationItemResponse {
    private Integer jobId;
    private String state;
    private Integer batchId;
    private String clientId;
    private String reference;
    private String type;
    private String productId;
    private String variant;
    private String variantPublic;
    private String productType;
    private String operation;
    private Integer prevOperationNum;
    private String description;
    private String p2Parameters;
    private Integer orderQuantity;
    private Integer remainingQuantity;
    private Integer processingTime;
    private Integer secondPerQuantity;
    private Integer completionPercentage;
    private Integer productionId;
    private List<JobRejectionDetailsItemResponse> jobRejectionDetails;
    private List<FileInfosItemResponse> fileInfos;
    private JobDetailsItemResponse jobDetails;
    private Boolean completed;
}
