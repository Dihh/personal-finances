package com.dehhvs.personalfinance;

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
        Location location = this.locationRepository.getReferenceById(2);
        System.out.println(location.getId());
        model.addAttribute("location", "location.getName()");
        return "home";
    }
}
