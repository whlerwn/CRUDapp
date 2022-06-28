package model;

import jakarta.persistence.*;

@Entity
@Table(name = "tea")
public class Tea extends Product {

    @Column(name = "province")
    private String province;

    @Column(name = "type")
    private String type;

    public Tea() {
    }

    public Tea(String name, String province, String type) {
        super(name);
        this.province = province;
        this.type = type;
    }

    public Tea(int id, String name, String province, String type) {
        super(id, name);
        this.province = province;
        this.type = type;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
