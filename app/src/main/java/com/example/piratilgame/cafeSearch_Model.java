package com.example.piratilgame;

public class cafeSearch_Model {

    String gemCount;

    public String getGemCount() {
        return gemCount;
    }

    public String getCafeName() {
        return cafeName;
    }

    public String getCafeAddress() {
        return cafeAddress;
    }

    String cafeName;
    String cafeAddress;

    public cafeSearch_Model(String gemCount, String cafeName, String cafeAddress) {
        this.gemCount = gemCount;
        this.cafeName = cafeName;
        this.cafeAddress = cafeAddress;
    }
}
