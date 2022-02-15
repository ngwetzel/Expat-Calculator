package com.expat.Model;

public class Brackets {
    private int bracketID;
    private boolean nhrsBracket;
    private int bracketLimit;
    private double percentage;

    public Brackets(int bracketID, boolean nhrsBracket, int bracketLimit, double percentage) {
        this.bracketID = bracketID;
        this.nhrsBracket = nhrsBracket;
        this.bracketLimit = bracketLimit;
        this.percentage = percentage;
    }

    public int getBracketID() {
        return bracketID;
    }

    public void setBracketID(int bracketID) {
        this.bracketID = bracketID;
    }

    public boolean isNhrsBracket() {
        return nhrsBracket;
    }

    public void setNhrsBracket(boolean nhrsBracket) {
        this.nhrsBracket = nhrsBracket;
    }

    public int getBracketLimit() {
        return bracketLimit;
    }

    public void setBracketLimit(int bracketLimit) {
        this.bracketLimit = bracketLimit;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
