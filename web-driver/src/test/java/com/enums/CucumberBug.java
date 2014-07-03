package com.enums;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

/**
 * Created by IntelliJ IDEA.
 * User: Rakesh Avasarala
 * Date: 6/30/14
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class CucumberBug {
    private LocalDate date1;
    private LocalTime time1;
    private LocalDate date2;

    public LocalDate getDate1() {
        return date1;
    }

    public void setDate1(final LocalDate date1) {
        this.date1 = date1;
    }

    public LocalTime getTime1() {
        return time1;
    }

    public void setTime1(final LocalTime time1) {
        this.time1 = time1;
    }

    public LocalDate getDate2() {
        return date2;
    }

    public void setDate2(final LocalDate date2) {
        this.date2 = date2;
    }
}
