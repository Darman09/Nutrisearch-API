package com.hitema.mongodb.springbootmongodb.resource;

import com.hitema.mongodb.springbootmongodb.document.Favoris;
import com.hitema.mongodb.springbootmongodb.document.Nutri;
import com.hitema.mongodb.springbootmongodb.repository.FavorisRepository;
import com.hitema.mongodb.springbootmongodb.repository.NutriRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("rest/favoris")
public class FavorisRessource {

    private FavorisRepository favorisRepository;
    public FavorisRessource(FavorisRepository favorisRepository) {
        this.favorisRepository = favorisRepository;
    }

    @GetMapping("/all")
    public List<Favoris> getAll() {
        return favorisRepository.findAllNotNullableProduct();
    }

    @GetMapping("/add")
    public Favoris addElementFavoris(@RequestParam(name= "idproduit") String idporoduit) {
        Random r = new Random();
        Integer n = r.nextInt(65535);
        return favorisRepository.save(new Favoris(n.toString(),idporoduit));
    }

    @GetMapping("/findByIdProduct")
    public List<Favoris> findByIdProduct(@RequestParam(name = "idproduit") String idproduit) {
        return favorisRepository.findProduitById(idproduit);
    }

    @GetMapping("/delete")
    public void deleteFavoris(@RequestParam(name = "id") String id) {
        favorisRepository.deleteById(id);
    }

}
