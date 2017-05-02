package com.sample.datajpa.to;

public class UserAdminsInfo {
    private String mark;
    private Integer bonus;
    private String comment;

    public UserAdminsInfo(String mark, Integer bonus, String comment) {
        this.mark = mark;
        this.bonus = bonus;
        this.comment = comment;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
