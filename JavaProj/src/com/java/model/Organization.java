package com.java.model;

import com.java.util.DateUtil;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static com.java.util.DateUtil.NOW;
import static com.java.util.DateUtil.of;

public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Link homePage;
    private final Collection<Position> position;

    public Organization(Link homePage, Collection<Position> position) {
        this.homePage = homePage;
        this.position = position;
    }

    public Organization(String name, String link, Position... positions) {
        this(new Link(name, link), Arrays.asList(positions));
    }

    public void setPeriod(LocalDate startDate, LocalDate endDate, String title, String descriptions) {
        position.add(new Position(startDate, endDate, title, descriptions));
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
                ", period=" + position +
                '}';
    }

     public static class Position implements Serializable {
         private static final long serialVersionUID = 1L;

        private final LocalDate startDate;
        private final LocalDate endDate;
        private final String title;
        private final String descriptions;

        public Position(int startYear, Month startMonth, String title, String descriptions) {
            this(of(startYear, startMonth), NOW, title, descriptions);
        }

         public Position(int startYear, Month startMonth, int endYear, Month endMonth, String title, String descriptions) {
             this(of(startYear, startMonth), of(endYear, endMonth), title, descriptions);
         }

        public Position(LocalDate startDate, LocalDate endDate, String title, String descriptions) {
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
            Position position = (Position) o;
            return startDate.equals(position.startDate) &&
                    endDate.equals(position.endDate) &&
                    title.equals(position.title) &&
                    Objects.equals(descriptions, position.descriptions);
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
}
