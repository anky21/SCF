package me.anky.scf;

/**
 * Created by Anky An on 3/04/2017.
 * anky25@gmail.com
 */

public class ChurchEvent {

    private String title;
    private String date;
    private String dateKey;
    private String location;
    private String time;
    private String context;
    private String imageUrl;

    public ChurchEvent() {
    }

    public ChurchEvent(String title, String date, String dateKey, String location, String time,
                       String context, String imageUrl) {
        this.title = title;
        this.date = date;
        this.dateKey = dateKey;
        this.location = location;
        this.time = time;
        this.context = context;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateKey() {
        return dateKey;
    }

    public void setDateKey(String dateKey) {
        this.dateKey = dateKey;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
