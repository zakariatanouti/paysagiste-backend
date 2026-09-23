package com.paysagiste.backend.model;

public class Realisation {
    private Long id;
    private String title;
    private String category;
    private String image;

    public Realisation(Long id, String title, String category, String image) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.image = image;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getImage() { return image; }
}
