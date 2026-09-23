package com.paysagiste.backend.controller;

import com.paysagiste.backend.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApiController {

    private final List<ServiceItem> services = Arrays.asList(
        new ServiceItem(1L, "Tonte de pelouse", 0.5, "fa-seedling"),
        new ServiceItem(2L, "Taille de haies", 2.5, "fa-scissors"),
        new ServiceItem(3L, "Pose de gazon en rouleau", 8.0, "fa-layer-group"),
        new ServiceItem(4L, "Création de terrasse bois", 75.0, "fa-cubes")
    );

    private final List<Realisation> realisations = Arrays.asList(
        new Realisation(1L, "Aménagement terrasse en teck", "terrasse", "https://images.unsplash.com/photo-1590086782957-93c06ef21a6d"),
        new Realisation(2L, "Taille de haie de cèdres", "taille", "https://images.unsplash.com/photo-1584479898061-15742e14f50d"),
        new Realisation(3L, "Pose de gazon synthétique", "gazon", "https://images.unsplash.com/photo-1592417817098-8f3d6ef23a28")
    );

    @GetMapping("/services")
    public List<ServiceItem> getServices() {
        return services;
    }

    @GetMapping("/realisations")
    public List<Realisation> getRealisations(@RequestParam(required = false, defaultValue = "all") String category) {
        if ("all".equalsIgnoreCase(category)) {
            return realisations;
        }
        return realisations.stream()
                .filter(r -> r.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    @PostMapping("/devis")
    public ResponseEntity<DevisResponse> createDevis(@RequestBody DevisRequest request) {
        ServiceItem service = services.stream()
                .filter(s -> s.getId().equals(request.getServiceId()))
                .findFirst()
                .orElse(null);

        if (service == null) {
            return ResponseEntity.badRequest().body(new DevisResponse(false, "Service introuvable", null));
        }

        double price = service.getBasePricePerM2() * request.getSurface();
        String formattedPrice = String.format("%.2f", price);

        DevisResponse.EstimateData estimate = new DevisResponse.EstimateData(
                service.getName(),
                request.getSurface(),
                formattedPrice
        );

        return ResponseEntity.ok(new DevisResponse(true, "Devis généré avec succès !", estimate));
    }
}
