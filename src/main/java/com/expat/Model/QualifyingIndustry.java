package com.expat.Model;

public class QualifyingIndustry {
    int industryID;
    String industryName;
    boolean isNHRS;

    public QualifyingIndustry(int industryID, String industryName, boolean isNHRS) {
        this.industryID = industryID;
        this.industryName = industryName;
        this.isNHRS = isNHRS;
    }

    public int getIndustryID() {
        return industryID;
    }

    public void setIndustryID(int industryID) {
        this.industryID = industryID;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public boolean isNHRS() {
        return isNHRS;
    }

    public void setNHRS(boolean NHRS) {
        isNHRS = NHRS;
    }
}
