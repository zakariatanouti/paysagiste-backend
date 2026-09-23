package com.paysagiste.backend.model;

public class DevisResponse {
    private boolean success;
    private String message;
    private EstimateData estimate;

    public DevisResponse(boolean success, String message, EstimateData estimate) {
        this.success = success;
        this.message = message;
        this.estimate = estimate;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public EstimateData getEstimate() { return estimate; }

    public static class EstimateData {
        private String service;
        private double surface;
        private String totalEstimatedPrice;

        public EstimateData(String service, double surface, String totalEstimatedPrice) {
            this.service = service;
            this.surface = surface;
            this.totalEstimatedPrice = totalEstimatedPrice;
        }

        public String getService() { return service; }
        public double getSurface() { return surface; }
        public String getTotalEstimatedPrice() { return totalEstimatedPrice; }
    }
}
