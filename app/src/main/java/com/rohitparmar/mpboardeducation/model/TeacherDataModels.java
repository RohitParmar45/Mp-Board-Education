package com.rohitparmar.mpboardeducation.model;

public class TeacherDataModels {
    private String name, email, post, Image , key , instagram ;

    public TeacherDataModels() {
    }

    public TeacherDataModels(String name, String email, String post, String image, String key, String instagram) {
        this.name = name;
        this.instagram = instagram;
        this.email = email;
        this.post = post;
        this.Image = image;
        this.key = key;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
