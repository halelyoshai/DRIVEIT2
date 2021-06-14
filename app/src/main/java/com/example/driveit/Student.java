package com.example.driveit;


public class Student extends Person
{

    private String numLessons;
    private String numtests;
    private String teacherName;
    private String key;
    private String imageUri;


    public Student(String name, String phoneNumber, String mail, String password) {
        super(name, phoneNumber, mail, password , false);
        this.numLessons = "0";
        this.numtests = "0";
        this.teacherName = "עדיין לא ידוע";
    }

    public Student() {
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}
