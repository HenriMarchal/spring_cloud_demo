package edu.marchal.scd_01_withoutspringcloud.web.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import edu.marchal.scd_01_withoutspringcloud.model.Product;
import edu.marchal.scd_01_withoutspringcloud.dao.ProductDao;
import edu.marchal.scd_01_withoutspringcloud.web.exceptions.ProduitIntrouvableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private final ProductDao productDao;

    public ProductController(ProductDao productDao){
        this.productDao = productDao;
    }

    //Récupérer la liste des produits
    @GetMapping("/Produits")
    public MappingJacksonValue listeProduits() {
        Iterable<Product> produits = productDao.findAll();
        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");
        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
        MappingJacksonValue produitsFiltres = new MappingJacksonValue(produits);
        produitsFiltres.setFilters(listDeNosFiltres);
        return produitsFiltres;
    }

    @GetMapping(value = "/Produits/{id}")
    public Optional<Product> afficherUnProduit(@PathVariable int id) {
        Optional<Product> produit = productDao.findById(id);
        if(produit.isEmpty()) throw new ProduitIntrouvableException("Le produit avec l'id " + id + " est INTROUVABLE. Écran Bleu si je pouvais.");
        return produit;
    }

    @PostMapping(value = "/Produits")
    public ResponseEntity<Product> ajouterProduit(@RequestBody Product product) {
        Product productAdded;
        try {
            productAdded = productDao.save(product);
        }
        catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
