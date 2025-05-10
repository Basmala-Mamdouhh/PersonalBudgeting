package Domain;

import java.io.Serializable;
import java.util.Date;

public class Reminder implements Serializable {
    private int reminderId;
    private int userId;
    private String title;
    private Date date;
    private Date time;
    private boolean isNotified;

    public Reminder(int reminderId, int userId, String title, Date date, Date time) {
        this.reminderId = reminderId;
        this.userId = userId;
        this.title = title;
        this.date = date;
        this.time = time;
        this.isNotified = false;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
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

    public boolean isNotified() {
        return isNotified;
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

    public void setNotified(boolean notified) {
        isNotified = notified;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Reminder) {
            return ((Reminder) obj).getReminderId() == this.reminderId;
        }
        return false;
    }

}