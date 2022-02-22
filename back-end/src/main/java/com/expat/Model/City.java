package com.expat.Model;

public class City {

    private int cityID;
    private String cityName;
    private String region;
    private  boolean isCoastal;
    private boolean borderSpain;
    private long population;
    private float costOfLiving;

    public City(int cityID, String cityName, String region, boolean isCoastal, boolean borderSpain, long population, float costOfLiving) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.region = region;
        this.isCoastal = isCoastal;
        this.borderSpain = borderSpain;
        this.population = population;
        this.costOfLiving = costOfLiving;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public boolean isCoastal() {
        return isCoastal;
    }

    public void setCoastal(boolean coastal) {
        isCoastal = coastal;
    }

    public boolean isBorderSpain() {
        return borderSpain;
    }

    public void setBorderSpain(boolean borderSpain) {
        this.borderSpain = borderSpain;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public float getCostOfLiving() {
        return costOfLiving;
    }

    public void setCostOfLiving(float costOfLiving) {
        this.costOfLiving = costOfLiving;
    }
}
