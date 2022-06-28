package model;

import jakarta.persistence.*;

@Entity
@Table(name = "chocolate")
public class Chocolate extends Product{

    @Column(name = "per_of_cocoa")
    private int percent;

    @Column(name = "country")
    private String country;

    public Chocolate() {
    }

    public Chocolate(String name, int percent, String country) {
        super(name);
        this.percent = percent;
        this.country = country;
    }

    public Chocolate(int id, String name, int percent, String country) {
        super(id, name);
        this.percent = percent;
        this.country = country;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
