package com.hitema.mongodb.springbootmongodb.resource;

import com.hitema.mongodb.springbootmongodb.document.Nutri;
import com.hitema.mongodb.springbootmongodb.repository.NutriRepository;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("rest/nutri")
public class NutriResource {

    private NutriRepository nutriRepository;
    public NutriResource(NutriRepository nutriRepository) {
        this.nutriRepository = nutriRepository;
    }

    @GetMapping("/all")
    public List<Nutri> getAll(){
        return nutriRepository.findAllNotNullableProduct();
    }

    @GetMapping("/findOne")
    public Optional<Nutri> getOneUser(@RequestParam(name = "id") String id) {
        return nutriRepository.findById(id);
    }


    @GetMapping("/allBy/")
    public  List<Nutri> getAllByCountries(@RequestParam(name="pays") String pays) {
        return nutriRepository.findAllByPays(pays);
    }

    @GetMapping("/allByScore/")
    public  List<Nutri> getAllByNutriscore(@RequestParam(name="nutriscore") String nutriscore) {
        return nutriRepository.findAllByCodeNutriscore(nutriscore);
    }

    @GetMapping("/allByElement/")
    public  List<Nutri> getAllByElement(@RequestParam(name="nutriscore") String nutriscore,@RequestParam(name="paysOrigine") String paysOrigine, @RequestParam(name="paysVente") String paysVente) {
        if (nutriscore != null && !paysOrigine.equals("") && !paysVente.equals("")) {
            return nutriRepository.findAllByAllElement(nutriscore, paysOrigine, paysVente);
        } else if (nutriscore != "" && paysOrigine != ""){
            return nutriRepository.findAllByNutriAndOrigine(nutriscore, paysOrigine);
        } else if(nutriscore != "" && paysVente != "") {
            return nutriRepository.findAllByNutriAndVente(nutriscore,paysVente);
        } else if(paysOrigine != "" && paysVente != "") {
            return nutriRepository.findAllByVenteAndOrigine(paysVente,paysOrigine);
        } else if (nutriscore != "") {
            return nutriRepository.findAllByCodeNutriscore(nutriscore);
        } else if (paysOrigine != ""){
            return nutriRepository.findAllByOrigine(paysOrigine);
        } else if (paysVente != "") {
            return nutriRepository.findAllByVente(paysVente);
        }
        return nutriRepository.findAllByCodeNutriscore(nutriscore);
    }

    @GetMapping("/allByPaysOrigine/")
    public  List<Nutri> getAllBypaysOrigine(@RequestParam(name="paysOrigine") String paysOrigine) {
        return nutriRepository.findAllByCodeNutriscore(paysOrigine);
    }

    @GetMapping("/allByPaysVente/")
    public  List<Nutri> getAllBypaysVente(@RequestParam(name="paysVente") String paysVente) {
        return nutriRepository.findAllByCodeNutriscore(paysVente);
    }

    @GetMapping("/add")
    public Nutri addElementNutriscore(@RequestParam(name = "nom") String nom, @RequestParam(name = "grade") String grade, @RequestParam(name = "packaging") String packaging, @RequestParam(name = "paysOrigine") String paysOrigine, @RequestParam(name = "paysVente") String paysVente, @RequestParam(name = "categorie") String categorie, @RequestParam(name = "ingredientDescription") String ingredientDescription, @RequestParam(name = "quantity") String quantity) {
        Random r = new Random();
        Integer n = r.nextInt(65535);
        return nutriRepository.save(new Nutri(n.toString(),nom,grade,packaging,paysOrigine,paysVente,categorie,ingredientDescription,quantity));
    }

    @GetMapping("/modify")
    public Nutri modifyElementNutriscore(@RequestParam(name = "id") String id, @RequestParam(name = "nom") String nom, @RequestParam(name = "grade") String grade, @RequestParam(name = "packaging") String packaging, @RequestParam(name = "paysOrigine") String paysOrigine, @RequestParam(name = "paysVente") String paysVente, @RequestParam(name = "categorie") String categorie, @RequestParam(name = "ingredientDescription") String ingredientDescription, @RequestParam(name = "quantity") String quantity) {
        nutriRepository.deleteById(id);
        return nutriRepository.save(new Nutri(id,nom,grade,packaging,paysOrigine,paysVente,categorie,ingredientDescription,quantity));
    }

    @GetMapping("/delete")
    public void deleteUser(@RequestParam(name = "id") String id) {
        nutriRepository.deleteById(id);
    }
}
