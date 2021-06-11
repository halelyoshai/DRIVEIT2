package com.example.driveit;


public class Teacher extends Person
{
    private String school;
    private String studyArea;
    private String lessonType;
    private String lessonLength;
    private String lessonPrice;
    private String numOfStudents;

    public Teacher(String name, String phoneNumber, String mail, String school, String studyArea, String lessonType, String lessonLength, String lessonPrice, String password) {
        super(name, phoneNumber, mail, password, true);
        this.school = school;
        this.studyArea = studyArea;
        this.lessonType = lessonType;
        this.lessonLength = lessonLength;
        this.lessonPrice = lessonPrice;
        this.numOfStudents = "0";
    }


    public String getLessonLength() {
        return lessonLength;
    }

    public void setLessonLength(String lessonLength) {
        this.lessonLength = lessonLength;
    }

    public String getSchool() { return school; }

    public void setSchool(String school) { this.school = school; }

    public String getStudyArea() { return studyArea; }

    public void setStudyArea(String studyArea) { this.studyArea = studyArea; }

    public String getLessonType() { return lessonType; }

    public void setLessonType(String lessonType) { this.lessonType = lessonType; }

    public String getLessonPrice() { return lessonPrice; }

    public void setLessonPrice(String lessonPrice) { this.lessonPrice = lessonPrice; }

    public String getNumOfStudents() { return numOfStudents; }

    public void setNumOfStudents(String numOfStudents) { this.numOfStudents = numOfStudents; }
}

