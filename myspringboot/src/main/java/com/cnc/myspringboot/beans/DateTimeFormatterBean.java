package com.cnc.myspringboot.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeFormatterBean {
    private LocalDate date;
    private LocalDateTime dateTime;
    private LocalTime time;

    public DateTimeFormatterBean(LocalDate date, LocalDateTime dateTime, LocalTime time) {
        this.date = date;
        this.dateTime = dateTime;
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
