package com.danhuang.crop;

public class Status {
    private Integer id;

    private String name;

    private Byte temperature;

    private Double moisture;

    private String production;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getTemperature() {
        return temperature;
    }

    public void setTemperature(Byte temperature) {
        this.temperature = temperature;
    }

    public Double getMoisture() {
        return moisture;
    }

    public void setMoisture(Double moisture) {
        this.moisture = moisture;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production == null ? null : production.trim();
    }
}