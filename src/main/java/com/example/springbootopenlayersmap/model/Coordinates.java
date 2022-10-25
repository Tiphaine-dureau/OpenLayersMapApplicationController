package com.example.springbootopenlayersmap.model;

public class Coordinates {
    private double lng;
    private double lat;

    public Coordinates() { }

    public Coordinates(Double lng, Double lat) {
        this.lng = lng;
        this.lat = lat;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

}
