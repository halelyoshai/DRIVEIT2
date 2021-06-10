package com.example.driveit;

public class Lesson {

    private String countlesson;
    private String date;

    public Lesson(String lessonnum, String date){
        this.countlesson=lessonnum;
        this.date=date;
    }
    public String getCountlesson(){ return countlesson;}
    public void setCountlesson(String countlesson){this.countlesson=countlesson;}

    public String getdate(){return date;}
    public void setdate(String date){this.date=date;}
}
