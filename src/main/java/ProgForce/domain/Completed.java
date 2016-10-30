package ProgForce.domain;


import java.util.Date;

public class Completed {
    private Long id;
    private String name;
    private Date initDate;
    private int priority;

    public Completed() {
    }

    public Completed(String name, Date initDate, int priority) {
        this.name = name;
        this.initDate = initDate;
        this.priority = priority;
    }

    public Completed(Long id, String name, Date initDate, int priority) {
        this.id = id;
        this.name = name;
        this.initDate = initDate;
        this.priority = priority;
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

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Completed{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", initDate=" + initDate +
                ", priority=" + priority +
                '}';
    }
}
