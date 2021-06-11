package com.example.driveit;


public class Student extends Person
{

    private String testpnimi;
    private String numLessons;
    private String numtests;
    private String teacherName;


    public Student(String name, String phoneNumber, String mail, String password) {
        super(name, phoneNumber, mail, password , false);
        this.testpnimi = "0";
        this.numLessons = "0";
        this.numtests = "0";
        this.teacherName = "עדיין לא ידוע";
    }

    public Student() {
    }

    public String getTestpnimi() {
        return testpnimi;
    }

    public void setTestpnimi(String testpnimi) {
        this.testpnimi = testpnimi;
    }

    public String getNumLessons() {
        return numLessons;
    }

    public void setNumLessons(String numLessons) {
        this.numLessons = numLessons;
    }

    public String getNumtests() {
        return numtests;
    }

    public void setNumtests(String numtests) {
        this.numtests = numtests;
    }

    public void setLessonslist(){ }

    public String getTeacherName() { return teacherName; }

    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }
}
