package com.example.mobsoft.myapplication.model;

/**
 * Created by gaaaron on 2017. 04. 03..
 */
import com.orm.dsl.Table;

import java.util.Date;

@Table
public class Concert {
    private String name;
    private Long id = null;
    private Date date;
    private String place;
    private Integer price;
    private String website;
    private boolean isFavourite;

    public Concert() {

    }

    public Concert(Long id, String name) {
        this.id = id;
        this.name = name;
        this.isFavourite = false;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean getIsFavourite() {
        return isFavourite;
    }
    public void setIsFavourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

}
