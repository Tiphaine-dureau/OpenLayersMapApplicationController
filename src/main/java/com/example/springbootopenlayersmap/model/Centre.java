package com.example.springbootopenlayersmap.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "coordinates",
})
public class Centre {
    @JsonProperty("type")
    private String type;
    @JsonProperty("coordinates")
    private Coordinates coordinates;

    public Centre() {
    }

    public Centre(String type, Double[] coordinates) {
        this.type = type;
        this.coordinates = new Coordinates(coordinates[0], coordinates[1]);
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }
    @JsonProperty("coordinates")
    public Coordinates getCoordinates() {
        return coordinates;
    }
    @JsonProperty("coordinates")
    public void setCoordinates(Double[] coordinates) {
        this.coordinates = new Coordinates(coordinates[0], coordinates[1]);
    }
}
