package com.example.driveit;


import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Teacher extends Person
{
    private ArrayList<Student> students;
    private String school;
    private String studyarea;
    private String lessontipe;
    private String lessonlength;
    private int lessonprice;

    public Teacher(String name, String mail, String password, String passwordagain) {
        super(name, mail, password, passwordagain, true);
        students=new ArrayList<Student>();
        this.school = school;
        this.studyarea= studyarea;
        this.lessontipe = lessontipe;
        this.lessonlength = lessonlength;
        this.lessonprice = lessonprice;
    }



    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(Student student) {
        this.students.add(student);
    }

    public String getLessonlength() {
        return lessonlength;
    }

    public void setLessonlength(String lessonlength) {
        this.lessonlength = lessonlength;
    }


    }

