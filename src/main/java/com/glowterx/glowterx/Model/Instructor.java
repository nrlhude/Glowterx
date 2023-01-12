package com.glowterx.glowterx.Model;

public class Instructor extends Person {
    private int instructorId;
    private String instructorPass;

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorPass() {
        return instructorPass;
    }

    public void setInstructorPass(String instructorPass) {
        this.instructorPass = instructorPass;
    }
}
