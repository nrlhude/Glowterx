package com.glowterx.glowterx.Model;

public class Trainee extends Person {
    private int traineeId;
    private String traineePass;

    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    public String getTraineePass() {
        return traineePass;
    }

    public void setTraineePass(String traineePass) {
        this.traineePass = traineePass;
    }
}
