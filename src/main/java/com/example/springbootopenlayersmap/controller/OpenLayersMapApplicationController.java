package com.example.springbootopenlayersmap.controller;

import com.example.springbootopenlayersmap.model.Geo;
import com.example.springbootopenlayersmap.model.Ville;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Objects;

@Controller
public class OpenLayersMapApplicationController {
    final RestTemplate restTemplate;

    public OpenLayersMapApplicationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/map")
    public String getThymeleafVue(Model model) throws NullPointerException {
        try {
            Ville maVille = new Ville("Montpellier");
            model.addAttribute("maVille", maVille);
            getLatLng(model, maVille.nom());
        } catch (Exception ignored) {
        }
        return "thymeleaf/index";
    }

    @PostMapping(value = "/map")
    public String setThymeleafVue(@ModelAttribute Ville maVille, Model model) {
        try {
            model.addAttribute("maVille", maVille);
            getLatLng(model, maVille.nom());
        } catch (Exception ignored) {
        }
        return "thymeleaf/index";
    }

    private void getLatLng(Model model, String ville) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            final String baseUrl =
                    "https://geo.api.gouv.fr/communes?nom="
                            + ville
                            + "&fields=centre&boost=population&limit=1";
            URI uri = new URI(baseUrl);

            ResponseEntity<Geo[]> geocode = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    Geo[].class);

            if (Objects.requireNonNull(geocode.getBody())[0].getCentre().getCoordinates() != null) {
                model.addAttribute("lat", geocode.getBody()[0].getCentre().getCoordinates().getLat());
                model.addAttribute("lng", geocode.getBody()[0].getCentre().getCoordinates().getLng());
            }
        } catch (Exception ignored) {
        }
    }

}
