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
public class JobsInformationResourceResponse {
    private String description;
    private String detailsUrl;
    private Boolean showDatacard;
    private List<JobsInformationItemResponse> jobsInformation;
    private List<String> ignoredUploadFiles;
    private List<String> validationFields;
    private List<RequiredFieldValidationDataItemResponse> requiredFieldValidationData;
    private Boolean combinedJob;
    private Boolean fileJobType;
    private String reference;
    private String type;
    private String operation;
    private String clientId;
    private String productType;
}
