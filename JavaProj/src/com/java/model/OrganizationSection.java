package com.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrganizationSection extends Section {
    private List<Organization> organizations;

    public OrganizationSection(List<Organization> organizations) {
        Objects.requireNonNull(organizations, "Organizations mast not be null");
        this.organizations = organizations;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public String toString() {
        return "OrganizationSection{" +
                "organizations=" + organizations +
                '}';
    }
}
