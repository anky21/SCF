package me.anky.scf;

/**
 * Created by Anky An on 3/04/2017.
 * anky25@gmail.com
 */

public class ChurchEvent {

    private String title;
    private String beginTime;
    private String endTime;
    private String date;
    private int dateKey;
    private String location;
    private String time;
    private String eventContext;
    private String imageUrl;

    public ChurchEvent() {
    }

    public ChurchEvent(String title, String begineTime, String endTime, String date, int dateKey, String location, String time,
                       String eventContext, String imageUrl) {
        this.title = title;
        this.beginTime = begineTime;
        this.endTime = endTime;
        this.date = date;
        this.dateKey = dateKey;
        this.location = location;
        this.time = time;
        this.eventContext = eventContext;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

    public int getDateKey() {
        return dateKey;
    }

    public void setDateKey(int dateKey) {
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

    public String getEventContext() {
        return eventContext;
    }

    public void setEventContext(String eventContext) {
        this.eventContext = eventContext;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
