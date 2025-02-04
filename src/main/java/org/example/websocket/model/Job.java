package org.example.websocket.model;

public class Job {
    private String id;
    private String category;
    private String title;
    private long batchId;
    private String batchType;
    private double income;
    private long remainTime;
    private long deadline;
    private String status;
    private String description;

    public Job() {}

    public Job(String id, String category, String title, long batchId, String batchType, double income, long remainTime, long deadline, String status, String description) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.batchId = batchId;
        this.batchType = batchType;
        this.income = income;
        this.remainTime = remainTime;
        this.deadline = deadline;
        this.status = status;
        this.description = description;
    }

    public String getId() { return id; }
    public String getCategory() { return category; }
    public String getTitle() { return title; }
    public long getBatchId() { return batchId; }
    public String getBatchType() { return batchType; }
    public double getIncome() { return income; }
    public long getRemainTime() { return remainTime; }
    public long getDeadline() { return deadline; }
    public String getStatus() { return status; }
    public String getDescription() { return description; }
}
