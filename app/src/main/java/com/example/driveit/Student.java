package com.example.driveit;

public class Student extends Person
{

    private int testpnimi;
    private int numlessons;
    private int numtests;
    private String keyPic;
    private Teacher teacher;

    public Student(String name, String phonenum, String mail,
                   String password) {
        super(name,  phonenum, mail, password , false);
        this.testpnimi = 0;
        this.numlessons = 0;
        this.numtests = 0;

    }

    public int getTestpnimi() {
        return testpnimi;
    }

    public void setTestpnimi(int testpnimi) {
        this.testpnimi = testpnimi;
    }

    public int getNumlessons() {
        return numlessons;
    }

    public void setNumlessons(int numlessons) {
        this.numlessons = numlessons;
    }

    public int getNumtests() {
        return numtests;
    }

    public void setNumtests(int numtests) {
        this.numtests = numtests;
    }

    public Teacher getT() {
        return teacher;
    }

    public void setT(Teacher t) {
        teacher = t;
    }
}
