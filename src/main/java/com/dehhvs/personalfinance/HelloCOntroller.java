package com.dehhvs.personalfinance;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dehhvs.personalfinance.models.Location;
import com.dehhvs.personalfinance.repositories.LocationRepository;

@Controller
public class HelloCOntroller {

    private LocationRepository locationRepository;

    public HelloCOntroller(LocationRepository locationRepository) {
        super();
        this.locationRepository = locationRepository;
    }

    @RequestMapping("/")
    public String index(ModelMap model) {
        List<Location> locations = this.locationRepository.findAll();
        System.out.println(locations);
        model.addAttribute("locations", locations);
        return "home";
    }
}
