package com.example.driveit;

public class Person
{
        private String name;
        private String phoneNumber;
        private String mail;
        private String password;
        private boolean isTeacher;


        public Person(){ }
        public Person(String name, String phoneNumber, String mail, String password, boolean isTeacher) {
                this.name = name;
                this.phoneNumber = phoneNumber;
                this.mail = mail;
                this.password = password;
                this.isTeacher = isTeacher;
        }


        public String getName() { return name; }

        public void setName(String name) {
                this.name = name;
        }

        public String getPhoneNumber() { return phoneNumber; }

        public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

        public String getMail() {
                return mail;
        }

        public void setMail(String mail) {
                this.mail = mail;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public boolean getIsTeacher() { return isTeacher; }

        public void setIsTeacher(boolean teacher) { isTeacher = teacher; }
}