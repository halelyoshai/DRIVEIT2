package com.example.driveit;

public class Test {

    private String counttest;
    private String date;
    public Test (){

    }

    public Test(String lessonnum, String date){
        this.counttest=lessonnum;
        this.date=date;
    }
    public String getCounttest(){ return counttest;}
    public void setCounttest(String countlesson){this.counttest=counttest;}

    public String getdate(){return date;}
    public void setdate(String date){this.date=date;}
}


