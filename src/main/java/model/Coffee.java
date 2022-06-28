package model;

import jakarta.persistence.*;

@Entity
@Table(name = "coffee")
public class Coffee extends Product {

    @Column(name = "region")
    private String region;

    @Column(name = "growth_height")
    private int growthHeight;

    public Coffee() {
    }

    public Coffee(String name, String region, int growthHeight) {
        super(name);
        this.region = region;
        this.growthHeight = growthHeight;
    }

    public Coffee(int id, String name, String region, int growthHeight) {
        super(id, name);
        this.region = region;
        this.growthHeight = growthHeight;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getGrowthHeight() {
        return growthHeight;
    }

    public void setGrowthHeight(int growthHeight) {
        this.growthHeight = growthHeight;
    }
}
