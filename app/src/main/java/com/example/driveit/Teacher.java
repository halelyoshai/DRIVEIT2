package com.example.driveit;

import java.util.ArrayList;

public class Teacher extends Person
{
    private ArrayList<Student> students;


    public Teacher(String name, String id, String phonenum, String mail, String studyarea, String school, String city, String lisensetype, String username, String password) {
        super(name, id, phonenum, mail, studyarea, school, city, lisensetype, username, password);
        students=new ArrayList<Student>();
    }
}
