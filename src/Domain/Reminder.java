package Domain;

import java.io.Serializable;
import java.util.Date;

public class Reminder implements Serializable {
    private int userId;
    private String title;
    private Date date;
    private Date time;

    public Reminder(int userId, String title, Date date, Date time) {
        this.userId = userId;
        this.title = title;
        this.date = date;
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public Date getTime() {
        return time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}