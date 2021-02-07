package com.example.driveit;

public class Student extends Person
{

    private int testpnimi;
    private int numlessons;
    private int numtests;
    private Teacher t;

    public Student(String name, String id, String phonenum, String mail, String studyarea, String school, String city, String lisensetype, String username, String password, int testpnimi, int numlessons, int numtests, Teacher t) {
        super(name, id, phonenum, mail, studyarea, school, city, lisensetype, username, password);
        this.testpnimi = testpnimi;
        this.numlessons = numlessons;
        this.numtests = numtests;
        this.t = t;
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
        return t;
    }

    public void setT(Teacher t) {
        this.t = t;
    }
}
