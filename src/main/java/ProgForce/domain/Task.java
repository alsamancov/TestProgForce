package ProgForce.domain;


import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task {
    private Long id;
    private String name;
    private Date date;
    private int priority;
    private boolean overdue;

    public Task() {
    }

    public Task(String name, Date date, int priority) {
        this.name = name;
        this.date = date;
        this.priority = priority;
    }

    public Task(Long id, String name, Date date, int priority) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.priority = priority;
    }

    public Task(Long id, String name, Date date, int priority, boolean overdue) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.priority = priority;
        this.overdue = overdue;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isOverdue() {
        long days = new Date().getTime() - this.getDate().getTime();
        long convert = TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);
        if(convert < 1){
            overdue = false;
        } else{
            overdue = true;
        }
        return overdue;

    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", priority=" + priority +
                ", overdue=" + overdue +
                '}';
    }
}
