package com.example.demo.models;

public class Employee {
    private int id;
    private String name;
    private String dolznost;
    private String zp;
    private String premiya;

    public Employee(int id, String name, String dolznost, String zp, String premiya) {
        this.id = id;
        this.name = name;
        this.dolznost = dolznost;
        this.zp = zp;
        this.premiya = premiya;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDolznost() {
        return dolznost;
    }

    public void setDolznost(String dolznost) {
        this.dolznost = dolznost;
    }

    public String getZp() {
        return zp;
    }

    public void setZp(String zp) {
        this.zp = zp;
    }

    public String getPremiya() {
        return premiya;
    }

    public void setPremiya(String premiya) {
        this.premiya = premiya;
    }
}
