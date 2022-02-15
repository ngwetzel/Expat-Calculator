package com.expat.Model;

public class Region {
    private int regionID;
    private String regionName;
    private double averageTempSummerF;
    private double averageTempWinterF;
    private double averageTempSummerC;
    private double averageTempWinterC;

    public Region(int regionID, String regionName, double averageTempSummerF, double averageTempWinterF, double averageTempSummerC, double averageTempWinterC) {
        this.regionID = regionID;
        this.regionName = regionName;
        this.averageTempSummerF = averageTempSummerF;
        this.averageTempWinterF = averageTempWinterF;
        this.averageTempSummerC = averageTempSummerC;
        this.averageTempWinterC = averageTempWinterC;
    }

    public int getRegionID() {
        return regionID;
    }

    public void setRegionID(int regionID) {
        this.regionID = regionID;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public double getAverageTempSummerF() {
        return averageTempSummerF;
    }

    public void setAverageTempSummerF(double averageTempSummerF) {
        this.averageTempSummerF = averageTempSummerF;
    }

    public double getAverageTempWinterF() {
        return averageTempWinterF;
    }

    public void setAverageTempWinterF(double averageTempWinterF) {
        this.averageTempWinterF = averageTempWinterF;
    }

    public double getAverageTempSummerC() {
        return averageTempSummerC;
    }

    public void setAverageTempSummerC(double averageTempSummerC) {
        this.averageTempSummerC = averageTempSummerC;
    }

    public double getAverageTempWinterC() {
        return averageTempWinterC;
    }

    public void setAverageTempWinterC(double averageTempWinterC) {
        this.averageTempWinterC = averageTempWinterC;
    }
}
