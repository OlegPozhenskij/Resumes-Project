package com.java.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private final Collection<Period> period;

    public Organization(String name, String link, Collection<Period> period) {
        Objects.requireNonNull(period, "period must not be null");
        this.homePage = new Link(name, link);
        this.period = period;
    }

    public void setPeriod(LocalDate startDate, LocalDate endDate, String title, String descriptions) {
        period.add(new Period(startDate, endDate, title, descriptions));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return homePage.equals(that.homePage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", period=" + period +
                '}';
    }
}
