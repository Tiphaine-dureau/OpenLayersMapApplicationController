package com.example.springbootopenlayersmap.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "centre",
        "nom",
        "code",
        "_score"
})
public class Geo {
    @JsonProperty("centre")
    private Centre centre;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("code")
    private String code;
    @JsonProperty("_score")
    private double _score;

    public Geo() {
    }

    public Geo(Centre centre, String nom, String code, double _score) {
        this.centre = centre;
        this.nom = nom;
        this.code = code;
        this._score = _score;
    }

    @JsonProperty("centre")
    public Centre getCentre() {
        return centre;
    }

    @JsonProperty("centre")
    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    @JsonProperty("nom")
    public String getNom() {
        return nom;
    }

    @JsonProperty("nom")
    public void setNom(String nom) {
        this.nom = nom;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("_score")
    public double get_score() {
        return _score;
    }

    @JsonProperty("_score")
    public void set_score(double _score) {
        this._score = _score;
    }

}
