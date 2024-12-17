package com.practice.SpringSecurity.Vo;

public class UserForm {
    public String name;
    public String mailId;
    public String passWord;
    public String userName;

    public UserForm() {
    }

    public UserForm(String name, String mailId, String passWord, String userName) {
        this.name = name;
        this.mailId = mailId;
        this.passWord = passWord;
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
