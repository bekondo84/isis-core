package com.teratech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class WelcomeUiController {

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // On passe une variable au template Thymeleaf
        model.addAttribute("message", "Bienvenue dans le module ERP Welcome !");
        System.out.println("-------------------- showDashboard(Model model) ----------------");
        // Le chemin correspond EXACTEMENT à l'arborescence dans les ressources du plugin
        // (Sans le préfixe "templates/" et sans le suffixe ".html")
        return "plugins/backoffice/dashboard";
    }
}
