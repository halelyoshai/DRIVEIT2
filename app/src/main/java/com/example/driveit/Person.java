package com.example.driveit;

public class Person
{
        private String name;
        private String id;
        private String phonenum;
        private String mail;
        private String studyarea;
        private String school;
        private String city;
        private String lisensetype;
        private String username;
        private String password;



        public Person(String name, String id, String phonenum, String mail, String studyarea, String school, String city, String lisensetype, String username, String password) {
                this.name = name;
                this.id = id;
                this.phonenum = phonenum;
                this.mail = mail;
                this.studyarea = studyarea;
                this.school= school;
                this.city = city;
                this.lisensetype = lisensetype;
                this.username = username;
                this.password = password;

        }

        public String getSchool() {
                return school;
        }

        public void setSchool(String school) {
                this.school = school;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getPhonenum() {
                return phonenum;
        }

        public void setPhonenum(String phonenum) {
                this.phonenum = phonenum;
        }

        public String getMail() {
                return mail;
        }

        public void setMail(String mail) {
                this.mail = mail;
        }

        public String getStudyarea() {
                return studyarea;
        }

        public void setStudyarea(String studyarea) {
                this.studyarea = studyarea;
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public String getLisensetype() {
                return lisensetype;
        }

        public void setLisensetype(String lisensetype) {
                this.lisensetype = lisensetype;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}