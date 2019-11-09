package com.hitema.mongodb.springbootmongodb.repository;

import com.hitema.mongodb.springbootmongodb.document.Nutri;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NutriRepository extends MongoRepository<Nutri, String> {

    @Query("{ 'nutrition_grades' : {$ne : null},'product_name_fr' : {$ne : null}  }")
    List<Nutri> findAllNotNullableProduct();

    @Query("{ 'countries' : ?0,'product_name_fr' : {$ne : null}   }")
    List<Nutri> findAllByPays(String pays);

    @Query("{ 'nutrition_grades' : ?0,'product_name_fr' : {$ne : null}   }")
    List<Nutri> findAllByCodeNutriscore(String nutriscore);

    @Query("{ 'nutrition_grades' : ?0,'product_name_fr' : {$ne : null}, 'manufacturing_places' : /?1/, 'countries' : /?2/}")
    List<Nutri> findAllByAllElement(String nutriscore, String paysOrigine, String paysVente);

    @Query("{ 'nutrition_grades' : ?0,'product_name_fr' : {$ne : null}, 'countries' : /?1/}")
    List<Nutri> findAllByNutriAndVente(String nutriscore, String paysVente);

    @Query("{ 'nutrition_grades' : ?0,'product_name_fr' : {$ne : null}, 'manufacturing_places' : /?1/}")
    List<Nutri> findAllByNutriAndOrigine(String nutriscore, String paysOrigine);

    @Query("{ 'product_name_fr' : {$ne : null}, 'countries' : /?0/, 'manufacturing_places' : /?1/}")
    List<Nutri> findAllByVenteAndOrigine(String paysVente, String paysOrigine);

    @Query("{ 'product_name_fr' : {$ne : null}, 'countries' : /?0/}")
    List<Nutri> findAllByVente(String paysVente);

    @Query("{ 'product_name_fr' : {$ne : null}, 'manufacturing_places' : /?0/}")
    List<Nutri> findAllByOrigine(String paysOrigine);
}
