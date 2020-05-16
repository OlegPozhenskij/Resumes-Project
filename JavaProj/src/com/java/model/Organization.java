package com.java.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;

public class Organization {
    private Link homePage;
    private LocalDate startDate;
    private LocalDate endDate;
    private Collection<Period> period;
    private String title;
    private String descriptions;

    public Organization(Link homePage, LocalDate startDate, LocalDate endDate, Collection<Period> period, String title, String descriptions) {
        this.homePage = homePage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.period = period;
        this.title = title;
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", period=" + period +
                ", title='" + title + '\'' +
                ", descriptions='" + descriptions + '\'' +
                '}';
    }
}
