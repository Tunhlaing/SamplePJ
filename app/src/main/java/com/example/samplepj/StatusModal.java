package com.example.samplepj;

public class StatusModal {
    private String modelName;
    private String modelStatus;
    private int id;

    public StatusModal(String modelName, String modelStatus,int id) {
        this.modelName = modelName;
        this.modelStatus = modelStatus;
        this.id=id;
    }

    public String getModelName() {
        return modelName;
    }

    public String getModelStatus() {
        return modelStatus;
    }
    public int getId() {
        return id;
    }
}
