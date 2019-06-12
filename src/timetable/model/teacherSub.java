/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.model;

/**
 *
 * @author Regis charles
 */
public class teacherSub {
    private String subject;
    private int semister,optional,lectureHour,practicalHour;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSemister() {
        return semister;
    }

    public void setSemister(int semister) {
        this.semister = semister;
    }

    public int getOptional() {
        return optional;
    }

    public void setOptional(int optional) {
        this.optional = optional;
    }

    public int getLectureHour() {
        return lectureHour;
    }

    public void setLectureHour(int lectureHour) {
        this.lectureHour = lectureHour;
    }

    public int getPracticalHour() {
        return practicalHour;
    }

    public void setPracticalHour(int practicalHour) {
        this.practicalHour = practicalHour;
    }
    
    
}
