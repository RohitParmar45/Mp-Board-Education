package com.rohitparmar.mpboardeducation.model;

import java.util.List;

public class User {
    private String subject, fee , dialog1 , registration  ;
    private List<String> val;

    public User() {
    }

    public User(String subject , String fee, String dialog1, String registration , List<String> val) {
        this.subject = subject;
        this.fee = fee;
        this.dialog1 = dialog1;
        this.registration = registration;
        this.val = val;

    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getDialog1() {
        return dialog1;
    }

    public void setDialog1(String dialog1) {
        this.dialog1 = dialog1;
    }

    public String getRegistration() {
        return registration;
    }

    public List<String> getVal() {
        return val;
    }

    public void setVal(List<String>  val) {
        this.val = val;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
