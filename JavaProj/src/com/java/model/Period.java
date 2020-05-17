package com.java.model;

import com.java.util.DateUtil;

import java.time.LocalDate;
import java.util.Objects;

public class Period {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String title;
    private final String descriptions;

    public Period(LocalDate startDate, LocalDate endDate, String title, String descriptions) {
        Objects.requireNonNull(title,"title must not be null");
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.descriptions = descriptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return startDate.equals(period.startDate) &&
                endDate.equals(period.endDate) &&
                title.equals(period.title) &&
                Objects.equals(descriptions, period.descriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, title, descriptions);
    }

    @Override
    public String toString() {
        return "Period{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", title='" + title + '\'' +
                ", descriptions='" + descriptions + '\'' +
                '}';
    }
}
