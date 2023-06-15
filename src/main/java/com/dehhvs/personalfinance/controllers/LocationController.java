package com.dehhvs.personalfinance.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.dehhvs.personalfinance.models.Location;
import com.dehhvs.personalfinance.repositories.LocationRepository;

@Controller
public class LocationController {

    private LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository) {
        super();
        this.locationRepository = locationRepository;
    }

    @RequestMapping("/locations")
    public String locations(ModelMap model) {
        List<Location> locations = this.locationRepository.findAll();
        model.addAttribute("locations", locations);
        return "location/index";
    }

    @RequestMapping("/locations/{id}")
    public String location(ModelMap model, @PathVariable Integer id) {
        Location location = this.locationRepository.findById(id).get();
        model.addAttribute("location", location);
        return "location/show";
    }

    @RequestMapping("/locations/new")
    public String newLocation(ModelMap model) {
        Location location = new Location();
        model.addAttribute("location", location);
        return "location/form";
    }

    @PostMapping("/locations")
    public RedirectView postLocation(ModelMap model, Location location) {
        this.locationRepository.save(location);
        return new RedirectView("/locations");
    }

    @RequestMapping("/locations/edit/{id}")
    public String editLocation(ModelMap model, @PathVariable Integer id) {
        Location location = this.locationRepository.findById(id).get();
        model.addAttribute("location", location);
        return "location/form";
    }

    @RequestMapping("/locations/delete/{id}")
    public RedirectView deleteLocation(ModelMap model, @PathVariable Integer id) {
        this.locationRepository.deleteById(id);
        return new RedirectView("/locations");
    }

}
