package edu.marchal.scd_01_withoutspringcloud.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/Produits")
    public String listeProduits() {
        return "Un exemple de produit";
    }
}
