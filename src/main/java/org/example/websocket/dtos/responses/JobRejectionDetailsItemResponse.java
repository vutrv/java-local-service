package org.example.websocket.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class JobRejectionDetailsItemResponse {
    private String description;
    private String id;
    private Integer number;
}
