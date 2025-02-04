package org.example.websocket.service;

import org.example.websocket.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    public List<Job> getJobList() {
        return List.of(
                createJob("1", "PE_EDIT", "Edit picture", 50000746651L, "TEST_DS", 20, 60000, 1673546400000L, "In Progress", "Description of job 1"),
                createJob("2", "PE_EDIT", "Edit picture", 50000746660L, "TEST_DS", 20, 60000, 1673546400000L, "Ready", "Description of job 2"),
                createJob("3", "PE_EDIT", "Edit picture", 50000746661L, "TEST_DS", 20, 60000, 1673546400000L, "On Hold", "Description of job 3"),
                createJob("4", "PE_EDIT", "Edit picture", 50000746670L, "TEST_DS", 20, 60000, 1673546400000L, "In Progress", "Description of job 4"),
                createJob("5", "PE_EDIT", "Edit picture", 50000746682L, "TEST_DS", 20, 60000, 1673546400000L, "In Progress", "Description of job 5"),
                createJob("6", "PE_EDIT", "Edit picture", 50000746654L, "TEST_DS", 20, 60000, 1673546400000L, "In Progress", "Description of job 6"),
                createJob("7", "PE_EDIT", "Edit picture", 50000746691L, "TEST_DS", 20, 60000, 1673546400000L, "In Progress", "Description of job 7")
        );
    }

    private Job createJob(String id, String category, String name, long jobId, String source, int priority, int estimatedTime, long timestamp, String status, String description) {
        return new Job(id, category, name, jobId, source, priority, estimatedTime, timestamp, status, description);
    }
}
