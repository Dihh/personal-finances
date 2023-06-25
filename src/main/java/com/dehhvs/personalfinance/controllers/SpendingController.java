package com.dehhvs.personalfinance.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.dehhvs.personalfinance.models.Spending;
import com.dehhvs.personalfinance.repositories.SpendingRepository;

@Controller
public class SpendingController {

    private SpendingRepository spendingRepository;

    public SpendingController(SpendingRepository spendingRepository) {
        super();
        this.spendingRepository = spendingRepository;
    }

    @RequestMapping("/spendings")
    public String spendings(ModelMap model) {
        List<Spending> spendings = this.spendingRepository.findAll();
        model.addAttribute("spendings", spendings);
        return "views/spending/index";
    }

    @RequestMapping("/spendings/{id}")
    public String spending(ModelMap model, @PathVariable Integer id) {
        Spending spending = this.spendingRepository.findById(id).get();
        model.addAttribute("spending", spending);
        return "views/spending/show";
    }

    @RequestMapping("/spendings/new")
    public String newSpending(ModelMap model) {
        Spending spending = new Spending();
        model.addAttribute("spending", spending);
        return "views/spending/form";
    }

    @PostMapping("/spendings")
    public RedirectView postSpending(ModelMap model, Spending spending) {
        this.spendingRepository.save(spending);
        return new RedirectView("/spendings");
    }

    @RequestMapping("/spendings/edit/{id}")
    public String editSpending(ModelMap model, @PathVariable Integer id) {
        Spending spending = this.spendingRepository.findById(id).get();
        model.addAttribute("spending", spending);
        return "views/spending/form";
    }

    @RequestMapping("/spendings/delete/{id}")
    public RedirectView deleteSpending(ModelMap model, @PathVariable Integer id) {
        this.spendingRepository.deleteById(id);
        return new RedirectView("/spendings");
    }
}
