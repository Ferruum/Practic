package com.example.demo.models;

public class Promotion {
    private int id;
    private String promotionname;
    private String promotiontime;
    private String conditions;
    private String pronocode;

    public Promotion(int id, String promotionname, String promotiontime, String conditions, String pronocode) {
        this.id = id;
        this.promotionname = promotionname;
        this.promotiontime = promotiontime;
        this.conditions = conditions;
        this.pronocode = pronocode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPromotionname() {
        return promotionname;
    }

    public void setPromotionname(String promotionname) {
        this.promotionname = promotionname;
    }

    public String getPromotiontime() {
        return promotiontime;
    }

    public void setPromotiontime(String promotiontime) {
        this.promotiontime = promotiontime;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getPronocode() {
        return pronocode;
    }

    public void setPronocode(String pronocode) {
        this.pronocode = pronocode;
    }
}
