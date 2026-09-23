package com.paysagiste.backend.model;

public class DevisRequest {
    private String name;
    private String email;
    private String phone;
    private Long serviceId;
    private double surface;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Long getServiceId() { return serviceId; }
    public void setServiceId(Long serviceId) { this.serviceId = serviceId; }
    public double getSurface() { return surface; }
    public void setSurface(double surface) { this.surface = surface; }
}
