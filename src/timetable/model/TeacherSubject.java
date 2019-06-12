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
public class TeacherSubject {
    private String practicalHours,lectureHours,teacherSubject;
    private int teacherId;

    public String getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(String teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

  

  
    public String getPracticalHours() {
        return practicalHours;
    }

    public void setPracticalHours(String practicalHours) {
        this.practicalHours = practicalHours;
    }

    public String getLectureHours() {
        return lectureHours;
    }

    public void setLectureHours(String lectureHours) {
        this.lectureHours = lectureHours;
    }
    
    
}
