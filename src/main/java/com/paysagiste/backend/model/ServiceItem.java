package com.paysagiste.backend.model;

public class ServiceItem {
    private Long id;
    private String name;
    private double basePricePerM2;
    private String icon;

    public ServiceItem(Long id, String name, double basePricePerM2, String icon) {
        this.id = id;
        this.name = name;
        this.basePricePerM2 = basePricePerM2;
        this.icon = icon;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getBasePricePerM2() { return basePricePerM2; }
    public String getIcon() { return icon; }
}
