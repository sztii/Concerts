package com.example.mobsoft.myapplication.model;

/**
 * Created by gaaaron on 2017. 04. 03..
 */
import com.example.mobsoft.myapplication.utils.GsonHelper;
import com.orm.dsl.Table;

import java.util.Date;

@Table
public class Concert {
    private Long id = null;
    private String name;
    private String date;
    private String place;
    private Integer price;
    private String website;
    private boolean isFavourite;

    public Concert() {

    }

    public Concert(String name) {
        this.name = name;
        this.isFavourite = false;
    }

    public Concert(Long id, String name) {
        this.id = id;
        this.name = name;
        this.isFavourite = false;
    }

    public Concert(Long id, String name, String date, String place, Integer price, String website, boolean isFavourite) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.place = place;
        this.price = price;
        this.website = website;
        this.isFavourite = isFavourite;
    }

    public void set(Concert concert) {
        this.name = concert.name;
        this.date = concert.date;
        this.place = concert.place;
        this.price = concert.price;
        this.website = concert.website;
        this.isFavourite = concert.isFavourite;
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

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
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

    public String toJson() {
        return GsonHelper.getGson().toJson(this);
    }
}
