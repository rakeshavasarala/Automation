package com.enums;

import java.util.List;

public class PartnerModel {

    private String partnerId;
    private String name;
    private String description;
    private List<PartnerService> services;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(final String partnerId) {
        this.partnerId = partnerId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public List<PartnerService> getServices() {
        return services;
    }

    public void setServices(final List<PartnerService> services) {
        this.services = services;
    }
}
