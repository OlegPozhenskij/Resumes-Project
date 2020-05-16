package com.java.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Organization {
    private final Link homePage;

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Collection<Period> period;
    private final String title;
    private final String descriptions;

    public Organization(String name, String link, LocalDate startDate, LocalDate endDate, Collection<Period> period, String title, String descriptions) {
        Objects.requireNonNull(startDate, "Content must not be null");
        Objects.requireNonNull(endDate, "Content must not be null");
        Objects.requireNonNull(period, "Content must not be null");
        Objects.requireNonNull(title,"Content must not be null");
        this.homePage = new Link(name, link);
        this.startDate = startDate;
        this.endDate = endDate;
        this.period = period;
        this.title = title;
        this.descriptions = descriptions;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return homePage.equals(that.homePage) &&
                startDate.equals(that.startDate) &&
                endDate.equals(that.endDate) &&
                period.equals(that.period) &&
                title.equals(that.title) &&
                Objects.equals(descriptions, that.descriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, startDate, endDate, period, title, descriptions);
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
