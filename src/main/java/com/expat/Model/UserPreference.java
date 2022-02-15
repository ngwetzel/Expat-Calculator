package com.expat.Model;

public class UserPreference {

    private int preferenceID;
    private int userID;
    private double salary;
    private String desiredTempRangeWinter;
    private String desiredTempRangeSummer;
    private oolean desiresCoastal;
    private  boolean desiresBorderSpain;
    private String desiredPopulationRange;
    private String desiredCostOfLiving;

    public UserPreference(int preferenceID, int userID, double salary, String desiredTempRangeWinter, String desiredTempRangeSummer, boolean desiresCoastal, boolean desiresBorderSpain, String desiredPopulationRange, String desiredCostOfLiving) {
        this.preferenceID = preferenceID;
        this.userID = userID;
        this.salary = salary;
        this.desiredTempRangeWinter = desiredTempRangeWinter;
        this.desiredTempRangeSummer = desiredTempRangeSummer;
        this.desiresCoastal = desiresCoastal;
        this.desiresBorderSpain = desiresBorderSpain;
        this.desiredPopulationRange = desiredPopulationRange;
        this.desiredCostOfLiving = desiredCostOfLiving;
    }

    public int getPreferenceID() {
        return preferenceID;
    }

    public void setPreferenceID(int preferenceID) {
        this.preferenceID = preferenceID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesiredTempRangeWinter() {
        return desiredTempRangeWinter;
    }

    public void setDesiredTempRangeWinter(String desiredTempRangeWinter) {
        this.desiredTempRangeWinter = desiredTempRangeWinter;
    }

    public String getDesiredTempRangeSummer() {
        return desiredTempRangeSummer;
    }

    public void setDesiredTempRangeSummer(String desiredTempRangeSummer) {
        this.desiredTempRangeSummer = desiredTempRangeSummer;
    }

    public boolean isDesiresCoastal() {
        return desiresCoastal;
    }

    public void setDesiresCoastal(boolean desiresCoastal) {
        this.desiresCoastal = desiresCoastal;
    }

    public boolean isDesiresBorderSpain() {
        return desiresBorderSpain;
    }

    public void setDesiresBorderSpain(boolean desiresBorderSpain) {
        this.desiresBorderSpain = desiresBorderSpain;
    }

    public String getDesiredPopulationRange() {
        return desiredPopulationRange;
    }

    public void setDesiredPopulationRange(String desiredPopulationRange) {
        this.desiredPopulationRange = desiredPopulationRange;
    }

    public String getDesiredCostOfLiving() {
        return desiredCostOfLiving;
    }

    public void setDesiredCostOfLiving(String desiredCostOfLiving) {
        this.desiredCostOfLiving = desiredCostOfLiving;
    }
}
