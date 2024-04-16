package com.example.demo.models;

public class Reviews {
    private int id;
    private String namecut;
    private String clientname;
    private String raiting;
    private String comment;

    public Reviews(int id, String namecut, String clientname, String raiting, String comment) {
        this.id = id;
        this.namecut = namecut;
        this.clientname = clientname;
        this.raiting = raiting;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamecut() {
        return namecut;
    }

    public void setNamecut(String namecut) {
        this.namecut = namecut;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getRaiting() {
        return raiting;
    }

    public void setRaiting(String raiting) {
        this.raiting = raiting;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
