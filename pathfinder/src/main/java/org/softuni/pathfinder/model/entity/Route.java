package org.softuni.pathfinder.model.entity;

import jakarta.persistence.*;
import org.softuni.pathfinder.model.enums.RouteLevel;

import java.util.Set;

@Entity
@Table(name ="routes")
public class Route extends BaseEntity {
    public Route() {
    }

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private RouteLevel level;

  //  @Column(nullable = false)
    private String name;

    @ManyToOne
    private User author;

    @Column(name = "video_url", nullable = false)
    private String videoUrl;

    @ManyToMany
    private Set<Category> categories;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public RouteLevel getLevel() {
        return level;
    }

    public void setLevel(RouteLevel level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}