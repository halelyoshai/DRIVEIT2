package com.example.driveit;

public class Person
{
        private String name;
        private String phonenum;
        private String mail;
        private String password;
        private String passwordagain;
        private boolean isteacher;


        public Person(){ }
        public Person(String name, String phonenum, String mail, String password, boolean isteacher) {
                this.name = name;
                this.phonenum = phonenum;
                this.mail = mail;
                this.password = password;
                this.passwordagain = passwordagain;
                this.isteacher= isteacher;


        }


        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getMail() {
                return mail;
        }

        public void setMail(String mail) {
                this.mail = mail;
        }

        public boolean isIsteacher() {
                return isteacher;
        }

        public void setIsteacher(boolean isteacher) {
                this.isteacher = isteacher;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getPasswordagain() {
                return passwordagain;
        }

        public void setPasswordagain(String passwordagain) {
                this.passwordagain = passwordagain;
        }
}