package com.example.akiik.schoolapp;

public class Student {
    String studentId,studentName,studentClass,studentSection,pemail;
    int sutAttendance,stuTotal;
    public Student(){

    }

    public Student(String studentId,String studentName,String studentClass,String studentSection,String pemail,int sutAttendance,int stuTotal) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentSection=studentSection;
        this.pemail=pemail;
        this.sutAttendance=sutAttendance;
        this.stuTotal=stuTotal;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public String getStudentSection(){
        return studentSection;
    }

    public String getPemail(){
        return pemail;
    }

    public int getSutAttendance() {
        return sutAttendance;
    }

    public int getStuTotal() {
        return stuTotal;
    }
}
